/**********************************************************************************************************************************
 -File Name         :   Theatre Service Controller
 -Author            :   Sandra Binoy
 -Creation Date     :   11-06-2020
 -Description       :   Controller to produce the Theatre Microservice.
 **********************************************************************************************************************************/
package com.cg.omts.theatre.controller;

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

import com.cg.omts.theatre.exception.TheatreNotFoundException;
import com.cg.omts.theatre.model.Theatre;
import com.cg.omts.theatre.model.TheatreList;
import com.cg.omts.theatre.service.ITheatreService;

@RestController
@Validated
public class TheatreController {

	@Autowired
	private ITheatreService service;

	//http://localhost:9052/theatre
	/**********************************************************************************************************************************
	 -Method Name       :   getAllTheatres
	 -Input Parameters  :   void
	 -Return Type       :	ResponseEntity<List<Theatre>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method for SELECT all values from Theatre Table
	 **********************************************************************************************************************************/
	@GetMapping("/theatre")
	public ResponseEntity<TheatreList> getAllTheatres(){
		
		List<Theatre> theatres = service.getAllTheatres();
		
		TheatreList theatreList = new TheatreList();
		theatreList.setTheatreList(theatres);

		return new ResponseEntity<>(theatreList, HttpStatus.OK);

	}

	//http://localhost:9052/theatre/PVR
	/**********************************************************************************************************************************
		 -Method Name       :   getTheatreByName
		 -Input Parameters  :   String theatreName
		 -Return Type       :	ResponseEntity<List<Theatre>>
		 -Author            :   Sandra Binoy
		 -Creation Date     :   11-06-2020
		 -Description       :   Method for SELECT a row from Theatre Table by its name
	 **********************************************************************************************************************************/
	@GetMapping("/theatre/{theatreName}")
	public ResponseEntity<TheatreList> getTheatreByName(@PathVariable("theatreName") String theatreName) throws TheatreNotFoundException{

		List<Theatre> theatres = service.getTheatreByName(theatreName);
		
		TheatreList theatreList = new TheatreList();
		theatreList.setTheatreList(theatres);

		return new ResponseEntity<>(theatreList, HttpStatus.OK);

	}

	//http://localhost:9052/theatre/101
	/**********************************************************************************************************************************
	 -Method Name       :   updateTheatre
	 -Input Parameters  :   Integer theatreId, Theatre theatre
	 -Return Type       :	ResponseEntity<Theatre>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to UPDATE a value in the Theatre Table
	 **********************************************************************************************************************************/
	@PutMapping("/theatre/{theatreId}")
	public ResponseEntity<Theatre> updateTheatre(@Valid @PathVariable("theatreId") Integer theatreId, @RequestBody Theatre theatre) throws TheatreNotFoundException{

		Theatre result = service.updateTheatre(theatreId, theatre);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	//http://localhost:9052/theatre
	/**********************************************************************************************************************************
	 -Method Name       :   entaddTheatre
	 -Input Parameters  :   Theatre theatre
	 -Return Type       :	ResponseEntity<Theatre>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to INSERT values into the Theatre Table
	 **********************************************************************************************************************************/
	@PostMapping("/theatre")
	public ResponseEntity<Theatre> addTheatre(@Valid @RequestBody Theatre theatre){

		Theatre result = service.addTheatre(theatre);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	//http://localhost:9052/theatre/111
	/**********************************************************************************************************************************
	 -Method Name       :   deleteTheatre
	 -Input Parameters  :   Integer theatreId
	 -Return Type       :	ResponseEntity<String>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to DELETE a value from Theatre Table
	 **********************************************************************************************************************************/
	@DeleteMapping("/theatre/{theatreId}")
	public ResponseEntity<String> deleteTheatre(@PathVariable("theatreId") Integer theatreId) throws TheatreNotFoundException{

		Boolean value = service.deleteTheatre(theatreId);
		if(Boolean.TRUE.equals(value))
			return new ResponseEntity<>("Theatre Entry has been successfully deleted!", HttpStatus.OK);
		else
			return new ResponseEntity<>("An error occurred!", HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolation(Exception e) {
		return new ResponseEntity<>("The request could not be processed. Error Message: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
