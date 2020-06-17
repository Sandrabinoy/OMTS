package com.cg.omts.moviebooking.dto;

public class Show {
	
	private Integer showId;
	private Integer theatreId;
	private String showName;
	private String startTime;
	private String endTime;
	private String movieName;

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
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

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", theatreId=" + theatreId + ", showName=" + showName + ", startTime="
				+ startTime + ", endTime=" + endTime + ", movieName=" + movieName + "]";
	}

	public Show(Integer showId, Integer theatreId, String showName, String startTime, String endTime,
			String movieName) {
		super();
		this.showId = showId;
		this.theatreId = theatreId;
		this.showName = showName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movieName = movieName;
	}

	public Show() {
		super();
	}

}
