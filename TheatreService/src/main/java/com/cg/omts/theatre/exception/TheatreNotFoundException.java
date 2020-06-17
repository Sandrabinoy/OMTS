/**********************************************************************************************************************************
 -File Name         :   Theatre Not Found Exception
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Exception class to throw exception when a value entered could not be found in the database
 **********************************************************************************************************************************/

package com.cg.omts.theatre.exception;

public class TheatreNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**********************************************************************************************************************************
	 -Method Name       :   TheatreNotFoundException
	 -Input Parameters  :   String message
	 -Return Type       :	null
	 -Author            :   Sandra Binoy
	 -Creation Date     :   12-06-2020
	 -Description       :   Method to throw exception with custom message
	 **********************************************************************************************************************************/
	
	
	
	public TheatreNotFoundException(String message) {
		
		super(message);
		
	}

}
