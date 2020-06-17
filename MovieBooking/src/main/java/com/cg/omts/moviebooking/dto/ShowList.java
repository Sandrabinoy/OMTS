package com.cg.omts.moviebooking.dto;

import java.util.List;

public class ShowList {
	
	private List<Show> showList;

	public List<Show> getShowList() {
		return showList;
	}

	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}

	@Override
	public String toString() {
		return "ShowList [showList=" + showList + "]";
	}

}
