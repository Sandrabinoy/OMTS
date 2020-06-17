/**********************************************************************************************************************************
 -File Name         :   Show Service Interface
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The service layer interface for Show Services
 **********************************************************************************************************************************/

package com.cg.omts.show.service;

import java.util.List;

import com.cg.omts.show.exception.ShowNotFoundException;
import com.cg.omts.show.model.Show;

public interface IShowService {
	
	/****************************************************************************************************************************
	 - Method Name      : getAllShows
	 - Input Parameters : void
	 - Return type      : List<Show>
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Select all shows from the data table
	  ****************************************************************************************************************************/ 
	
	public List<Show> getAllShows();

	/****************************************************************************************************************************
	 - Method Name      : getShowByName
	 - Input Parameters : String showName
	 - Return type      : List<Show>
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Select all shows by their name
	  * @throws ShowNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public List<Show> getShowByName(String showName) throws ShowNotFoundException;

	/****************************************************************************************************************************
	 - Method Name      : updateShow
	 - Input Parameters : Integer showId, Show show
	 - Return type      : Show
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Update shows by their showId
	  * @throws ShowNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public Show updateShow(Integer showId, Show show) throws ShowNotFoundException;

	/****************************************************************************************************************************
	 - Method Name      : addShow
	 - Input Parameters : Show show
	 - Return type      : Show
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Insert a show
	  ****************************************************************************************************************************/ 
	
	public Show addShow(Show show);

	/****************************************************************************************************************************
	 - Method Name      : deleteShow
	 - Input Parameters : Integer showId
	 - Return type      : Boolean
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Delete a show by its ID
	 * @throws ShowNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public Boolean deleteShow(Integer showId) throws ShowNotFoundException;

}
