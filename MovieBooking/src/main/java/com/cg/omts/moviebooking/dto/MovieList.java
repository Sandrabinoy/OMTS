package com.cg.omts.moviebooking.dto;

import java.util.List;

public class MovieList {

    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

	@Override
	public String toString() {
		return "MovieList [movieList=" + movieList + "]";
	}

}
