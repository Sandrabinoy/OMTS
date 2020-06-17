/**********************************************************************************************************************************
 -File Name         :   Show Not Found Exception
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Exception class to throw exception when a value entered could not be found in the database
 **********************************************************************************************************************************/

package com.cg.omts.show.exception;

public class ShowNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**********************************************************************************************************************************
	 -Method Name       :   ShowNotFoundException
	 -Input Parameters  :   String message
	 -Return Type       :	null
	 -Author            :   Sandra Binoy
	 -Creation Date     :   12-06-2020
	 -Description       :   Method to throw exception with custom message
	 **********************************************************************************************************************************/
	
	
	
	public ShowNotFoundException(String message) {
		
		super(message);
		
	}

}
