package com.cg.omts.moviebooking.dto;

public class ShowOMTS {

    private Integer showId;
    private Integer theatreId;
    private String showName;
    private String startTime;
    private String endTime;
    private Movie movie;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public ShowOMTS(Integer showId, Integer theatreId, String showName, String startTime, String endTime, Movie movie) {
        this.showId = showId;
        this.theatreId = theatreId;
        this.showName = showName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
    }

    public ShowOMTS() {
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", theatreId=" + theatreId +
                ", showName='" + showName + '\'' +
                ", movie=" + movie +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

}
