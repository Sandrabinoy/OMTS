/**********************************************************************************************************************************
 -File Name         :   Movie Booking Controller
 -Author            :   Sandra Binoy
 -Creation Date     :   11-06-2020
 -Description       :   End point Controller used to consume the Movie, Theatre, and Show Microservices.
 **********************************************************************************************************************************/

package com.cg.omts.moviebooking.controller;

import com.cg.omts.moviebooking.dto.*;
import com.cg.omts.moviebooking.exception.FetchingException;
import com.cg.omts.moviebooking.exception.MovieNotFoundException;
import com.cg.omts.moviebooking.exception.ShowNotFoundException;
import com.cg.omts.moviebooking.exception.TheatreNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieBookingController {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String MOVIE_URL = "http://movie-service/movie";
	private static final String THEATRE_URL = "http://theatre-service/theatre";
	private static final String SHOW_URL = "http://show-service/show";
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBookingController.class);

	/*
	 * CONSUMPTION OF THEATRE MICROSERVICE
	 */
	//http://localhost:9049/theatre
	/**********************************************************************************************************************************
	 -Method Name       :   getTheatres
	 -Input Parameters  :   void
	 -Return Type       :	ResponseEntity<List<TheatreOMTS>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to SELECT all rows and display the Theatre Table with the movies
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@GetMapping("/theatre")
	public ResponseEntity<List<TheatreOMTS>> getTheatres() throws FetchingException{

		//Get all Theatres, get the list of movies, append it

		MovieList movies;
		List<Theatre> theatreList;
		
		try {
			movies = restTemplate.getForObject(MOVIE_URL, MovieList.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e);
			
		}

		try {
			
			theatreList = restTemplate.getForObject(THEATRE_URL, TheatreList.class).getTheatreList();
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e.getCause());
			
		}

		List<TheatreOMTS> listOfTheatres = new ArrayList<>();

		for(Theatre theatre:theatreList) {

			TheatreOMTS theatreOMTS = new TheatreOMTS(theatre.getTheatreId(), theatre.getTheatreName(), theatre.getTheatreCity(), movies);
			listOfTheatres.add(theatreOMTS);

		}

		return new ResponseEntity<>(listOfTheatres, HttpStatus.OK);

	}

	//http://localhost:9049/theatre/PVR
	/**********************************************************************************************************************************
	 -Method Name       :   getTheatreByName
	 -Input Parameters  :   String theatreName
	 -Return Type       :	ResponseEntity<List<Theatre>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method for SELECT a row from Theatre Table by its name
	 * @throws TheatreNotFoundException 
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@GetMapping("/theatre/{theatreName}")
	public ResponseEntity<List<TheatreOMTS>> getTheatreByName(@PathVariable("theatreName") String theatreName) throws TheatreNotFoundException, FetchingException {

		//Get Theatres by name, get the list of movies, append it
		MovieList movies;
		List<Theatre> theatreList;
		
		try {			

			 movies = restTemplate.getForObject(MOVIE_URL, MovieList.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new TheatreNotFoundException("Incorrect theatre name");
			
		}

		try{
			
			theatreList = restTemplate.getForObject(THEATRE_URL+"/"+theatreName, TheatreList.class).getTheatreList();
			
		}catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e.getCause());
			
		}

		List<TheatreOMTS> listOfTheatres = new ArrayList<>();

		for(Theatre theatre:theatreList) {

			TheatreOMTS theatreOMTS = new TheatreOMTS(theatre.getTheatreId(), theatre.getTheatreName(), theatre.getTheatreCity(), movies);
			listOfTheatres.add(theatreOMTS);

		}

		return new ResponseEntity<>(listOfTheatres, HttpStatus.OK);

	}

	//http://localhost:9049/theatre/1001
	/**********************************************************************************************************************************
	 -Method Name       :   updateTheatre
	 -Input Parameters  :   Integer theatreId, Theatre theatre
	 -Return Type       :	ResponseEntity<Theatre>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to UPDATE a value in the Theatre Table
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@PutMapping("/theatre/{theatreId}")
	public ResponseEntity<Theatre> updateTheatre(@PathVariable("theatreId") Integer theatreId, @RequestBody Theatre theatre) throws TheatreNotFoundException, FetchingException{

		HttpEntity<Theatre> entity = new HttpEntity<>(theatre);
		
		try {

		return restTemplate.exchange(THEATRE_URL+"/"+theatreId, HttpMethod.PUT, entity, Theatre.class);
		
		}catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e.getCause());
			
		}

	}

	//http://localhost:9049/theatre
	/**********************************************************************************************************************************
	 -Method Name       :   addTheatre
	 -Input Parameters  :   Theatre theatre
	 -Return Type       :	ResponseEntity<Theatre>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to INSERT values into the Theatre Table
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@PostMapping("/theatre")
	public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) throws FetchingException{

		HttpEntity<Theatre> entity = new HttpEntity<>(theatre);
		
		try {

			return restTemplate.exchange(THEATRE_URL, HttpMethod.POST, entity, Theatre.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e.getCause());
			
		}

	}

	//http://localhost:9049/theatre/1004
	/**********************************************************************************************************************************
	 -Method Name       :   deleteTheatre
	 -Input Parameters  :   Integer theatreId
	 -Return Type       :	ResponseEntity<String>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to DELETE a value from Theatre Table
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@DeleteMapping("/theatre/{theatreId}")
	public ResponseEntity<String> deleteTheatre(@PathVariable("theatreId") Integer theatreId) throws FetchingException {
		
		try {
			
			return restTemplate.exchange(THEATRE_URL+"/"+theatreId, HttpMethod.DELETE, null, String.class);
			
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e.getMessage());
			
		}

	}

	/*
	 * CONSUMPTION OF MOVIE MICROSERVICE
	 */

	//http://localhost:9049/movie
	/**********************************************************************************************************************************
	 -Method Name       :   getAllMovies
	 -Input Parameters  :   void
	 -Return Type       :	ResponseEntity<MovieList>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to SELECT all rows and display the Movie Table
	 **********************************************************************************************************************************/
	@GetMapping("/movie")
	public ResponseEntity<MovieList> getAllMovies(){
		
		return restTemplate.exchange(MOVIE_URL, HttpMethod.GET, null, MovieList.class);
		
	}
	
	//http://localhost:9049/movie/Interstellar
	/**********************************************************************************************************************************
	 -Method Name       :   getMovieByName
	 -Input Parameters  :   String movieName
	 -Return Type       :	ResponseEntity<Movie>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to SELECT and display a movie by its name
	 **********************************************************************************************************************************/
	@GetMapping("/movie/{movieName}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName) throws MovieNotFoundException
	{
		
		try {
			
			return restTemplate.exchange(MOVIE_URL+"/"+movieName, HttpMethod.GET, null, Movie.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new MovieNotFoundException("Something went wrong! "+e.getCause());
			
		}
		
		
	}
	
	//http://localhost:9049/movie
	/**********************************************************************************************************************************
	 -Method Name       :   addMovie
	 -Input Parameters  :   Movie movie
	 -Return Type       :	ResponseEntity<Movie>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to INSERT into the 
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@PostMapping("/movie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) throws FetchingException {
		
		HttpEntity<Movie> entity = new HttpEntity<>(movie);
		
		try {
			
			return restTemplate.exchange(MOVIE_URL, HttpMethod.POST, entity, Movie.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e.getCause());
			
		}
		
	}
	
	//http://localhost:9049/movie/111
	/**********************************************************************************************************************************
	 -Method Name       :   updateMovie
	 -Input Parameters  :   Integer movieId, Movie movie
	 -Return Type       :	ResponseEntity<Movie>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to UPDATE values of a movie using its ID
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@PutMapping("/movie/{movieId}")
	public ResponseEntity<Movie> updateMovie(@PathVariable("movieId") Integer movieId, @RequestBody Movie movie) throws FetchingException {
		
		HttpEntity<Movie> entity = new HttpEntity<>(movie);
		
		try {
			
			return restTemplate.exchange(MOVIE_URL+"/"+movieId, HttpMethod.PUT, entity, Movie.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong! "+e.getCause());
			
		}
		
	}
	
	//http://localhost:9049/movie/111
	/**********************************************************************************************************************************
	 -Method Name       :   deleteMovie
	 -Input Parameters  :   Integer movieId
	 -Return Type       :	ResponseEntity<List<Show>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to DELETE value from the Movie Table by its ID
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@DeleteMapping("/movie/{movieId}")
	public ResponseEntity<String> deleteMovie(@PathVariable("movieId") Integer movieId) throws FetchingException{
		
		try {
			
			return restTemplate.exchange(MOVIE_URL+"/"+movieId, HttpMethod.DELETE, null, String.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong!"+e.getCause());
			
		}
		
	}
	
	/*
	 * CONSUMPTION OF SHOW SERVICE
	 */
	
	//http://localhost:9049/show
	/**********************************************************************************************************************************
	 -Method Name       :   getAllShows
	 -Input Parameters  :   void
	 -Return Type       :	ResponseEntity<List<Show>>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method for SELECT all values from Show Table
	 * @throws FetchingException 
	 **********************************************************************************************************************************/
	@GetMapping("/show")
	public ResponseEntity<List<ShowOMTS>> getAllShows() throws FetchingException{
		
		//Get all shows, map each movie name from show to fetch the movie object from Movie
		ResponseEntity<ShowList> response;
		try {
			
			response = restTemplate.exchange(SHOW_URL, HttpMethod.GET, null, ShowList.class);
			
		} catch (Exception e) {
			
			LOGGER.debug(e.getMessage());
			throw new FetchingException("Something went wrong!"+e.getCause());
			
		}
		
		List<Show> shows = response.getBody().getShowList();
		
		List<ShowOMTS> showList = new ArrayList<>();
		
		for(Show show:shows) {
			
			Movie movie = restTemplate.getForObject(MOVIE_URL+"/"+show.getMovieName(), Movie.class);
			ShowOMTS showOMTS = new ShowOMTS(show.getShowId(), show.getTheatreId(), show.getShowName(), show.getStartTime(), show.getEndTime(), movie);
			showList.add(showOMTS);
			
		}
		
		return new ResponseEntity<>(showList, HttpStatus.OK);

	}
	
	//http://localhost:9049/show/Alpha
		/**********************************************************************************************************************************
		 -Method Name       :   getShowByName
		 -Input Parameters  :   String showName
		 -Return Type       :	ResponseEntity<List<Show>>
		 -Author            :   Sandra Binoy
		 -Creation Date     :   11-06-2020
		 -Description       :   Method to SELECT row by showName from Show Table
		 **********************************************************************************************************************************/
		@GetMapping("/show/{showName}")
		public ResponseEntity<List<ShowOMTS>> getShowByName(@PathVariable("showName") String showName)
		{
			
			ResponseEntity<ShowList> response = restTemplate.exchange(SHOW_URL+"/"+showName, HttpMethod.GET, null, ShowList.class);
			
			List<Show> shows = response.getBody().getShowList();
			
			List<ShowOMTS> showList = new ArrayList<>();
			
			for(Show show:shows) {
			
			Movie movie = restTemplate.getForObject(MOVIE_URL+"/"+show.getMovieName(), Movie.class);
			
			ShowOMTS showOMTS = new ShowOMTS(show.getShowId(), show.getTheatreId(), show.getShowName(), show.getStartTime(), show.getEndTime(), movie);
			showList.add(showOMTS);
			
			}
			
			return new ResponseEntity<>(showList, HttpStatus.OK);
			
		}
		
		//http://localhost:9049/show
		/**********************************************************************************************************************************
		 -Method Name       :   addShow
		 -Input Parameters  :   Show show
		 -Return Type       :	ResponseEntity<Show>
		 -Author            :   Sandra Binoy
		 -Creation Date     :   11-06-2020
		 -Description       :   Method to INSERT a new row into the Show Table
		 **********************************************************************************************************************************/
		@PostMapping("/show")
		public ResponseEntity<Show> addShow(@RequestBody Show show) {
			
			HttpEntity<Show> entity = new HttpEntity<>(show);
			
			return restTemplate.exchange(SHOW_URL, HttpMethod.POST, entity, Show.class);
			
		}
		
		//http://localhost:9049/show/1
		/**********************************************************************************************************************************
		 -Method Name       :   updateShow
		 -Input Parameters  :   Integer showId, Show show
		 -Return Type       :	ResponseEntity<Show>
		 -Author            :   Sandra Binoy
		 -Creation Date     :   11-06-2020
		 -Description       :   Method to UPDATE a row from Show Table
		 **********************************************************************************************************************************/
		@PutMapping("/show/{showId}")
		public ResponseEntity<Show> updateShow(@PathVariable("showId") Integer showId, @RequestBody Show show) {
			
			HttpEntity<Show> entity = new HttpEntity<>(show);
			
			return restTemplate.exchange(SHOW_URL+"/"+showId, HttpMethod.PUT, entity, Show.class);
			
		}
		
		//http://localhost:9049/show/3
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
		public ResponseEntity<String> deleteShow(@PathVariable("showId") Integer showId) throws ShowNotFoundException {
			
			try {

				return restTemplate.exchange(SHOW_URL+"/"+showId, HttpMethod.DELETE, null, String.class);
				
			} catch (Exception e) {
				
				LOGGER.debug(e.getMessage());
				throw new ShowNotFoundException("Something went wrong! "+e.getCause());
				
			}
			
		}
		
		@ExceptionHandler(Exception.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		ResponseEntity<String> handleConstraintViolation(Exception e) {
			return new ResponseEntity<>("" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

}
