/**********************************************************************************************************************************
 -File Name         :   Movie Service Interface
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The service layer interface for Movie Services
 **********************************************************************************************************************************/

package com.cg.omts.movie.service;

import java.util.List;

import com.cg.omts.movie.exception.MovieNotFoundException;
import com.cg.omts.movie.model.Movie;

public interface IMovieService {
	
	/****************************************************************************************************************************
	 - Method Name      : addMovie
	 - Input Parameters : Movie movie
	 - Return type      : Movie
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Insert a movie
	  ****************************************************************************************************************************/ 
	
	public Movie addMovie(Movie movie);

	/****************************************************************************************************************************
	 - Method Name      : getAllMovies
	 - Input Parameters : void
	 - Return type      : List<Movie>
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Select all movies from the data table
	  ****************************************************************************************************************************/ 
	
	public List<Movie> getAllMovies();

	/****************************************************************************************************************************
	 - Method Name      : updateMovie
	 - Input Parameters : Integer movieId, Movie movie
	 - Return type      : Movie
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Update Movie by their ID
	  * @throws MovieNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public Movie updateMovie(Integer movieId, Movie movie) throws MovieNotFoundException;

	/****************************************************************************************************************************
	 - Method Name      : deleteMovie
	 - Input Parameters : Integer movieId
	 - Return type      : Boolean
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Delete a movie by its ID
	 * @throws MovieNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public Boolean deleteMovie(Integer movieId) throws MovieNotFoundException;

	/****************************************************************************************************************************
	 - Method Name      : getMovieByName
	 - Input Parameters : String movieName
	 - Return type      : List<Movie>
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Select movie by its name
	  * @throws MovieNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public Movie getMovieByName(String movieName) throws MovieNotFoundException;

}
