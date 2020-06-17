/**********************************************************************************************************************************
 -File Name         :   Show 
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The model class of Show
 **********************************************************************************************************************************/
package com.cg.omts.show.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Show {
	
	private Integer showId;
//	@NotNull(message = "Show name cannot be null")
	@NotEmpty(message = "Show name cannot be empty")
	@NotBlank(message = "Show name cannot be left blank")
	private String showName;
	private Integer theatreId;
	private String movieName;
	@Pattern(regexp = "^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$")
	private String startTime;
	@Pattern(regexp = "^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$")
	private String endTime;

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
		return "ShowEntity [showId=" + showId + ", showName=" + showName + ", theatreId=" + theatreId + ", movieName="
				+ movieName + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public Show(Integer showId, String showName, Integer theatreId, String movieName, String startTime,
			String endTime) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.theatreId = theatreId;
		this.movieName = movieName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Show(){

	}

}
