/**********************************************************************************************************************************
 -File Name         :   Theatre Entity
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Entity class used to create the table instance of object Theatre
 **********************************************************************************************************************************/

package com.cg.omts.theatre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TheatreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public TheatreEntity(Integer theatreId, String theatreName, String theatreCity) {
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
	}

	public TheatreEntity() {
	}

	@Override
	public String toString() {
		return "TheatreEntity{" +
				"theatreId=" + theatreId +
				", theatreName='" + theatreName + '\'' +
				", theatreCity='" + theatreCity + '\'' +
				'}';
	}

}
