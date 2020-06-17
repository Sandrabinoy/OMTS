/**********************************************************************************************************************************
 -File Name         :   Show Service Controller
 -Author            :   Sandra Binoy
 -Creation Date     :   11-06-2020
 -Description       :   Controller to produce the Show Microservice.
 **********************************************************************************************************************************/

package com.cg.omts.show.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omts.show.exception.ShowNotFoundException;
import com.cg.omts.show.model.Show;
import com.cg.omts.show.model.ShowList;
import com.cg.omts.show.service.IShowService;

@RestController
@Validated
public class ShowController {

	@Autowired
	private IShowService service;
	
	//http://localhost:9053/show
	/**********************************************************************************************************************************
	 -Method Name       :   getAllShows
	 -Input Parameters  :   void
	 -Return Type       :	ResponseEntity<List<Show>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method for SELECT all values from Show Table
	 **********************************************************************************************************************************/
	@GetMapping("/show")
	public ResponseEntity<ShowList> getAllShows(){
		
		List<Show> shows = service.getAllShows();
		
		ShowList showList = new ShowList();
		showList.setShowList(shows);

		return new ResponseEntity<>(showList, HttpStatus.OK);

	}
	
	//http://localhost:9053/show/Alpha
	/**********************************************************************************************************************************
	 -Method Name       :   getShowByName
	 -Input Parameters  :   String showName
	 -Return Type       :	ResponseEntity<List<Show>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to SELECT row by showName from Show Table
	 * @throws ShowNotFoundException 
	 **********************************************************************************************************************************/
	@GetMapping("/show/{showName}")
	public ResponseEntity<ShowList> getShowByName(@PathVariable("showName") String showName) throws ShowNotFoundException 
	{

		List<Show> shows = service.getShowByName(showName);
		
		ShowList showList = new ShowList();
		showList.setShowList(shows);

		return new ResponseEntity<>(showList, HttpStatus.OK);

	}
	
	//http://localhost:9053/show
	/**********************************************************************************************************************************
	 -Method Name       :   addShow
	 -Input Parameters  :   Show show
	 -Return Type       :	ResponseEntity<Show>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to INSERT a new row into the Show Table
	 **********************************************************************************************************************************/
	@PostMapping("/show")
	public ResponseEntity<Show> addShow(@Valid @RequestBody Show show) {

		Show result = service.addShow(show);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	//http://localhost:9053/show/1
	/**********************************************************************************************************************************
	 -Method Name       :   updateShow
	 -Input Parameters  :   Integer showId, Show show
	 -Return Type       :	ResponseEntity<Show>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to UPDATE a row from Show Table
	 * @throws ShowNotFoundException 
	 **********************************************************************************************************************************/
	@PutMapping("/show/{showId}")
	public ResponseEntity<Show> updateShow(@Valid @PathVariable("showId") Integer showId, @Valid @RequestBody Show show) throws ShowNotFoundException {

		Show result = service.updateShow(showId, show);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	//http://localhost:9053/show/3
	/**********************************************************************************************************************************
	 -Method Name       :   deleteShow
	 -Input Parameters  :   Integer showId
	 -Return Type       :	ResponseEntity<String>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method for DELETE a row from Show Table
	 * @throws ShowNotFoundException 
	 **********************************************************************************************************************************/
	@DeleteMapping("/show/{showId}")
	public ResponseEntity<String> deleteShow(@PathVariable("showId") Integer showId) throws ShowNotFoundException{

		Boolean value = service.deleteShow(showId);
		if(Boolean.TRUE.equals(value))
			return new ResponseEntity<>("Show Entry has been successfully deleted!", HttpStatus.OK);
		else
			return new ResponseEntity<>("An error occurred!", HttpStatus.BAD_REQUEST);

	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolation(Exception e) {
		return new ResponseEntity<>("The request could not be processed. Error Message: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
