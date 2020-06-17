/**********************************************************************************************************************************
 -File Name         :   Movie Entity
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Entity class used to create the table instance of object Movie
 **********************************************************************************************************************************/

package com.cg.omts.movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName
				+ ", movieDirector=" + movieDirector + ", movieDescription=" + movieDescription + ", movieImage="
				+ movieImage + ", movieVideo=" + movieVideo + "]";
	}

	public MovieEntity(Integer movieId, String movieName, String movieDirector, String movieDescription,
			String movieImage, String movieVideo) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieDescription = movieDescription;
		this.movieImage = movieImage;
		this.movieVideo = movieVideo;
	}

	public MovieEntity() {
		super();
	}

}
