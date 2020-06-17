package com.cg.omts.moviebooking.dto;

public class Movie {

    private Integer movieId;
    private String movieName;
    private String movieDescription;
    private String movieDirector;
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

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
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

    public Movie(Integer movieId, String movieName, String movieDescription, String movieDirector, String movieImage, String movieVideo) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieDirector = movieDirector;
        this.movieImage = movieImage;
        this.movieVideo = movieVideo;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieImage='" + movieImage + '\'' +
                ", movieVideo='" + movieVideo + '\'' +
                '}';
    }

}
