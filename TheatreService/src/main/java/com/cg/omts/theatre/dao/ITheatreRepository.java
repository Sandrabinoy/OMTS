/**********************************************************************************************************************************
 -File Name         :   Theatre Repository Interface
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Repository interface used to connect to the database 
 **********************************************************************************************************************************/

package com.cg.omts.theatre.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.omts.theatre.entity.TheatreEntity;

@Repository
public interface ITheatreRepository extends JpaRepository<TheatreEntity, Integer> {

	/**********************************************************************************************************************************
	 -Method Name       :   findAllByTheatreName
	 -Input Parameters  :   String theatreName
	 -Return Type       :	List<TheatreEntity>
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to get a list of theatres by name
	 **********************************************************************************************************************************/

	
	List<TheatreEntity> findAllByTheatreName(String theatreName);

}
