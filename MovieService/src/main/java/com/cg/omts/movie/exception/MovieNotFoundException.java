/**********************************************************************************************************************************
 -File Name         :   Movie Not Found Exception
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Exception class to throw exception when a value entered could not be found in the database
 **********************************************************************************************************************************/

package com.cg.omts.movie.exception;

public class MovieNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**********************************************************************************************************************************
	 -Method Name       :   MovieNotFoundException
	 -Input Parameters  :   String message
	 -Return Type       :	null
	 -Author            :   Sandra Binoy
	 -Creation Date     :   12-06-2020
	 -Description       :   Method to throw exception with custom message
	 **********************************************************************************************************************************/
	
	
	public MovieNotFoundException(String message) {

		super(message);
		
	}

}
