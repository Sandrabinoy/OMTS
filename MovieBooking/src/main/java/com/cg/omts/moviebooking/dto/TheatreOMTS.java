package com.cg.omts.moviebooking.dto;

public class TheatreOMTS {

    private Integer theatreId;
    private String theatreName;
    private String theatreCity;
    private MovieList movies;

    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreCity() {
        return theatreCity;
    }

    public void setTheatreCity(String theatreCity) {
        this.theatreCity = theatreCity;
    }

    public MovieList getMovies() {
        return movies;
    }

    public void setMovies(MovieList movies) {
        this.movies = movies;
    }

    public TheatreOMTS(Integer theatreId, String theatreName, String theatreCity, MovieList movies) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreCity = theatreCity;
        this.movies = movies;
    }

    public TheatreOMTS() {
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", theatreCity='" + theatreCity + '\'' +
                ", movies=" + movies +
                '}';
    }

}
