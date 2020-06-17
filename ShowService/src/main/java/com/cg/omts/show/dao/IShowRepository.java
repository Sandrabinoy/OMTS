/**********************************************************************************************************************************
 -File Name         :   Show Repository Interface
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Repository interface used to connect to the database 
 **********************************************************************************************************************************/


package com.cg.omts.show.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.omts.show.entity.ShowEntity;

public interface IShowRepository extends JpaRepository<ShowEntity, Integer> {
	
	/**********************************************************************************************************************************
	 -Method Name       :   findByShowName
	 -Input Parameters  :   String showName
	 -Return Type       :	List<ShowEntity>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to get a list of shows by name
	 **********************************************************************************************************************************/

	List<ShowEntity> findAllByShowName(String showName);

}
