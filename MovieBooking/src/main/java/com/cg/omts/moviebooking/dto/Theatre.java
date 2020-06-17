package com.cg.omts.moviebooking.dto;

public class Theatre {

	private Integer theatreId;
	private String theatreName;
	private String theatreCity;

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

	public Theatre(Integer theatreId, String theatreName, String theatreCity) {
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
	}

	public Theatre() {
	}

	@Override
	public String toString() {
		return "Theatre{" +
				"theatreId=" + theatreId +
				", theatreName='" + theatreName + '\'' +
				", theatreCity='" + theatreCity + '\'' +
				'}';
	}

}
