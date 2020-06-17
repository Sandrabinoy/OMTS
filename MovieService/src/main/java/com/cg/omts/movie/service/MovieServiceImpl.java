/**********************************************************************************************************************************
 -File Name         :   Movie Service
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The implementation of the IMovieService class
 **********************************************************************************************************************************/
package com.cg.omts.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cg.omts.movie.dao.IMovieRepository;
import com.cg.omts.movie.entity.MovieEntity;
import com.cg.omts.movie.exception.MovieNotFoundException;
import com.cg.omts.movie.model.Movie;


@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private IMovieRepository repository;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

	//The PostMapping method to INSERT the movieEntity object into the table
	@Override
	public Movie addMovie(Movie movie) {

		Boolean isDuplicate = repository.existsByMovieName(movie.getMovieName());

		if(Boolean.FALSE.equals(isDuplicate)) {
			LOGGER.debug("addMovie implemented");
			MovieEntity entity = new MovieEntity();

			entity.setMovieName(movie.getMovieName());
			entity.setMovieDirector(movie.getMovieDirector());
			entity.setMovieDescription(movie.getMovieDescription());
			entity.setMovieImage(movie.getMovieImage());
			entity.setMovieVideo(movie.getMovieVideo());

			MovieEntity movieEntity = repository.saveAndFlush(entity);

			movie.setMovieId(movieEntity.getMovieId());

			return movie;
		}
		else {
			LOGGER.debug("Duplicate value caught!");
			throw new DuplicateKeyException("This movie name already exists!");
		}

	}

	//The GetMapping method to SELECT all the rows and return them
	@Override
	public List<Movie> getAllMovies() {

		List<MovieEntity> entityList = repository.findAll();
		List<Movie> movies = new ArrayList<>();
		for(MovieEntity entity: entityList) {

			Movie movie = new Movie();
			movie.setMovieId(entity.getMovieId());
			movie.setMovieName(entity.getMovieName());
			movie.setMovieDirector(entity.getMovieDirector());
			movie.setMovieDescription(entity.getMovieDescription());
			movie.setMovieImage(entity.getMovieImage());
			movie.setMovieVideo(entity.getMovieVideo());
			movies.add(movie);

		}
		return movies;

	}

	//The PutMapping method to UPDATE values of the movie object in the table by their ID
	@Override
	public Movie updateMovie(Integer movieId, Movie movie) throws MovieNotFoundException{

		Optional<MovieEntity> optional = repository.findById(movieId);
		if(optional.isPresent()) {
			MovieEntity updatedMovie = optional.get();
			updatedMovie.setMovieName(movie.getMovieName());
			updatedMovie.setMovieDirector(movie.getMovieDirector());
			updatedMovie.setMovieDescription(movie.getMovieDescription());
			updatedMovie.setMovieImage(movie.getMovieImage());
			updatedMovie.setMovieVideo(movie.getMovieVideo());
			repository.saveAndFlush(updatedMovie);

			Movie movieModel = new Movie();
			movieModel.setMovieId(updatedMovie.getMovieId());
			movieModel.setMovieName(updatedMovie.getMovieName());
			movieModel.setMovieDirector(updatedMovie.getMovieDirector());
			movieModel.setMovieDescription(updatedMovie.getMovieDescription());
			movieModel.setMovieImage(updatedMovie.getMovieImage());
			movieModel.setMovieVideo(updatedMovie.getMovieVideo());

			return movieModel;
		}
		else
			throw new MovieNotFoundException("Incorrect Movie ID");

	}

	//The DeleteMapping method to delete an entry from the table by its ID
	@Override
	public Boolean deleteMovie(Integer movieId) throws MovieNotFoundException {

		Boolean result = false;

		try {
			repository.deleteById(movieId);
			result = true;
		}catch (Exception e) {
			throw new MovieNotFoundException("Incorrect Movie ID");
		}
		return result;
	}

	//The GetMapping method to get a movie by its name and return it
	@Override
	public Movie getMovieByName(String movieName) throws MovieNotFoundException{

		Optional<MovieEntity> optional = Optional.of(repository.findByMovieName(movieName));
		Movie movie = new Movie();

		if(Boolean.TRUE.equals(optional.isPresent())) {

			MovieEntity entity = optional.get();

			movie.setMovieId(entity.getMovieId());
			movie.setMovieName(entity.getMovieName());
			movie.setMovieDirector(entity.getMovieDirector());
			movie.setMovieDescription(entity.getMovieDescription());
			movie.setMovieImage(entity.getMovieImage());
			movie.setMovieVideo(entity.getMovieVideo());

		}

		return movie;

	}

}
