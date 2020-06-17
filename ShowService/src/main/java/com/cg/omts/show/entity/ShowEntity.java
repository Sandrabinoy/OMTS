/**********************************************************************************************************************************
 -File Name         :   Show Entity
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Entity class used to create the table instance of object Show
 **********************************************************************************************************************************/

package com.cg.omts.show.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class ShowEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showId;
	private String showName;
	@Min(3)
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

	public ShowEntity(Integer showId, String showName, Integer theatreId, String movieName, String startTime,
			String endTime) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.theatreId = theatreId;
		this.movieName = movieName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public ShowEntity() {
		super();
	}

}
