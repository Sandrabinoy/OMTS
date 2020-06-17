/**********************************************************************************************************************************
 -File Name         :   Movie
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The model class of Movie
 **********************************************************************************************************************************/
package com.cg.omts.movie.model;

import org.springframework.stereotype.Component;


@Component
public class Movie {
	
	private Integer movieId;
	private String movieName;
	private String movieDirector;
	private String movieDescription;
	private String movieImage;
	private String movieVideo;
	
	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public String getMovieVideo() {
		return movieVideo;
	}

	public void setMovieVideo(String movieVideo) {
		this.movieVideo = movieVideo;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName
				+ ", movieDirector=" + movieDirector + ", movieDescription=" + movieDescription + ", movieImage="
				+ movieImage + ", movieVideo=" + movieVideo + "]";
	}

	public Movie(Integer movieId, String movieName, String movieDirector, String movieDescription,
			String movieImage, String movieVideo) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieDescription = movieDescription;
		this.movieImage = movieImage;
		this.movieVideo = movieVideo;
	}

	public Movie() {
		super();
	}

}
