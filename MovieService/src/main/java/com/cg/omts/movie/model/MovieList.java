/**********************************************************************************************************************************
 -File Name         :   Movie List
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The model class of a list of Movie
 **********************************************************************************************************************************/
package com.cg.omts.movie.model;

import java.util.List;

public class MovieList {

    private List<Movie> movies;

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movies = movieList;
    }

}
