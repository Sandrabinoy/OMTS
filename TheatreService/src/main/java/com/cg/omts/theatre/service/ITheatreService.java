/**********************************************************************************************************************************
 -File Name         :   Theatre Service Interface
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The service layer interface for Theatre Services
 **********************************************************************************************************************************/

package com.cg.omts.theatre.service;

import java.util.List;

import com.cg.omts.theatre.exception.TheatreNotFoundException;
import com.cg.omts.theatre.model.Theatre;

public interface ITheatreService {
	
	/****************************************************************************************************************************
	 - Method Name      : getAllTheatres
	 - Input Parameters : void
	 - Return type      : List<Theatre>
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Select all theatres from the data table
	  ****************************************************************************************************************************/ 
	
	public List<Theatre> getAllTheatres();

	/****************************************************************************************************************************
	 - Method Name      : getTheatreByName
	 - Input Parameters : String theatreName
	 - Return type      : List<Theatre>
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Select all theatres by their name
	  * @throws TheatreNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public List<Theatre> getTheatreByName(String theatreName) throws TheatreNotFoundException;

	/****************************************************************************************************************************
	 - Method Name      : updateTheatre
	 - Input Parameters : Integer theatreId, Theatre theatre
	 - Return type      : Theatre
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Update theatres by their theatreId
	  * @throws TheatreNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public Theatre updateTheatre(Integer theatreId, Theatre theatre) throws TheatreNotFoundException;

	/****************************************************************************************************************************
	 - Method Name      : addTheatre
	 - Input Parameters : Theatre theatre
	 - Return type      : Theatre
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Insert a theatre
	  ****************************************************************************************************************************/ 
	
	public Theatre addTheatre(Theatre theatre);

	/****************************************************************************************************************************
	 - Method Name      : deleteTheatre
	 - Input Parameters : Integer theatreId
	 - Return type      : Boolean
	 - Author           : Sandra Binoy
	 - Creation Date    : 13-06-2020
	 - Description      : Delete a theatre by its ID
	 * @throws TheatreNotFoundException 
	  ****************************************************************************************************************************/ 
	
	public Boolean deleteTheatre(Integer theatreId) throws TheatreNotFoundException;

}
