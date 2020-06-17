/**********************************************************************************************************************************
 -File Name         :   Movie Repository Interface
 -Author            :   Sandra Binoy
 -Creation Date     :   12-06-2020
 -Description       :   Repository interface used to connect to the database 
 **********************************************************************************************************************************/


package com.cg.omts.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.omts.movie.entity.MovieEntity;

@Repository
public interface IMovieRepository extends JpaRepository<MovieEntity, Integer> {
	
	/**********************************************************************************************************************************
	 -Method Name       :   findByMovieName
	 -Input Parameters  :   String movieName
	 -Return Type       :	MovieEntity
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to get a movie by its name
	 **********************************************************************************************************************************/

	MovieEntity findByMovieName(String movieName);
	
	/**********************************************************************************************************************************
	 -Method Name       :   existsByMovieName
	 -Input Parameters  :   String movieName
	 -Return Type       :	Boolean
	 -Author            :   Sandra Binoy
	 -Creation Date     :   11-06-2020
	 -Description       :   Method to check if a movie exists by its name
	 **********************************************************************************************************************************/

	Boolean existsByMovieName(String movieName);

}
