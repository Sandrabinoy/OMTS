/**********************************************************************************************************************************
 -File Name         :   Movie Service Controller
 -Author            :   Sandra Binoy
 -Creation Date     :   11-06-2020
 -Description       :   Controller to produce the Movie Microservice.
 **********************************************************************************************************************************/

package com.cg.omts.movie.controller;

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

import com.cg.omts.movie.exception.MovieNotFoundException;
import com.cg.omts.movie.model.Movie;
import com.cg.omts.movie.model.MovieList;
import com.cg.omts.movie.service.IMovieService;

import java.util.List;

@RestController
@Validated
public class MovieController {
	
	@Autowired
	private IMovieService service;
	
	//Method to get a list of all the movies
	//http://localhost:9051/movie
	/**********************************************************************************************************************************
	 -Method Name       :   getAllMovies
	 -Input Parameters  :   void
	 -Return Type       :	ResponseEntity<List<Movie>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to SELECT all rows and display the Movie Table
	 **********************************************************************************************************************************/
	@GetMapping("/movie")
	public ResponseEntity<MovieList> getAllMovies(){
		
		List<Movie> list = service.getAllMovies();
		
		MovieList movies = new MovieList();
		movies.setMovieList(list);

		return new ResponseEntity<>(movies, HttpStatus.OK);
		
	}
	
	//http://localhost:9051/movie/Interstellar
	/**********************************************************************************************************************************
	 -Method Name       :   getMovieByName
	 -Input Parameters  :   String movieName
	 -Return Type       :	ResponseEntity<Movie>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to SELECT and display a movie by its name
	 * @throws MovieNotFoundException 
	 **********************************************************************************************************************************/
	@GetMapping("/movie/{movieName}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName) throws MovieNotFoundException 
	{
		
		Movie result = service.getMovieByName(movieName);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	//Method to add a movie into the movie table
	//http://localhost:9051/movie
	/**********************************************************************************************************************************
	 -Method Name       :   addMovie
	 -Input Parameters  :   Movie movie
	 -Return Type       :	ResponseEntity<Movie>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to INSERT into the 
	 **********************************************************************************************************************************/
	@PostMapping("/movie")
	public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
		
		Movie result = service.addMovie(movie);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	//Method to update a movie by its ID
	//http://localhost:9051/movie/111
	/**********************************************************************************************************************************
	 -Method Name       :   updateMovie
	 -Input Parameters  :   Integer movieId, Movie movie
	 -Return Type       :	ResponseEntity<Movie>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to UPDATE values of a movie using its ID
	 * @throws MovieNotFoundException 
	 **********************************************************************************************************************************/
	@PutMapping("/movie/{movieId}")
	public ResponseEntity<Movie> updateMovie(@Valid @PathVariable("movieId") Integer movieId, @Valid @RequestBody Movie movie) throws MovieNotFoundException {
		
		Movie result = service.updateMovie(movieId, movie);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	//Method to delete movie by its ID
	//http://localhost:9051/movie/111
	/**********************************************************************************************************************************
	 -Method Name       :   deleteMovie
	 -Input Parameters  :   Integer movieId
	 -Return Type       :	ResponseEntity<List<Show>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to DELETE value from the Movie Table by its ID
	 * @throws MovieNotFoundException 
	 **********************************************************************************************************************************/
	@DeleteMapping("/movie/{movieId}")
	public ResponseEntity<String> deleteMovie(@PathVariable("movieId") Integer movieId) throws MovieNotFoundException{

		Boolean value = service.deleteMovie(movieId);
		if(Boolean.TRUE.equals(value))
			return new ResponseEntity<>("Movie Entry has been successfully deleted!", HttpStatus.OK);
		else
			return new ResponseEntity<>("An error occurred!", HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolation(Exception e) {
		return new ResponseEntity<>("The request could not be processed. Error Message: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
