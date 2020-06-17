/**********************************************************************************************************************************
 -File Name         :   Theatre List
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The model class of a list of Theatres
 **********************************************************************************************************************************/
package com.cg.omts.theatre.model;

import java.util.List;

public class TheatreList {
	
	private List<Theatre> theatres;

	public List<Theatre> getTheatreList() {
		return theatres;
	}

	public void setTheatreList(List<Theatre> theatreList) {
		this.theatres = theatreList;
	}

}
