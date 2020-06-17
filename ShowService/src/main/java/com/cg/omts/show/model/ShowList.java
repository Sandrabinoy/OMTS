package com.cg.omts.show.model;

import java.util.List;

public class ShowList {
	
	private List<Show> listOfShow;

	public List<Show> getShowList() {
		return listOfShow;
	}

	public void setShowList(List<Show> showList) {
		this.listOfShow = showList;
	}

	@Override
	public String toString() {
		return "ShowList [showList=" + listOfShow + "]";
	}

}
