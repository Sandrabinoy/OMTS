/**********************************************************************************************************************************
 -File Name         :   Theatre Service
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The implementation of the ITheatreService class
 **********************************************************************************************************************************/
package com.cg.omts.theatre.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.theatre.dao.ITheatreRepository;
import com.cg.omts.theatre.entity.TheatreEntity;
import com.cg.omts.theatre.exception.TheatreNotFoundException;
import com.cg.omts.theatre.model.Theatre;

@Service
public class TheatreServiceImpl implements ITheatreService {
	
	@Autowired
	private ITheatreRepository repository;

	//GetMapping method to SELECT all rows and return them
	@Override
	public List<Theatre> getAllTheatres() {
		
		List<TheatreEntity> entityList = repository.findAll();
		List<Theatre> theatres = new ArrayList<>();
		for(TheatreEntity entity:entityList) {
			
			Theatre theatre = new Theatre();
			theatre.setTheatreId(entity.getTheatreId());
			theatre.setTheatreName(entity.getTheatreName());
			theatre.setTheatreCity(entity.getTheatreCity());
			theatres.add(theatre);
			
		}
		return theatres;
		
	}

	//GetMapping method to get theatre(s) by its name and return it
	@Override
	public List<Theatre> getTheatreByName(String theatreName) throws TheatreNotFoundException {
		
		List<Theatre> theatres = new ArrayList<>();
		
		//Validate the functioning of it---------------------------------------------------------------------------------------------------
		List<TheatreEntity> entityList = repository.findAllByTheatreName(theatreName);
		
		if(!entityList.isEmpty()) {
			
			for(TheatreEntity entity:entityList) {
				
				Theatre theatre = new Theatre();
				theatre.setTheatreId(entity.getTheatreId());
				theatre.setTheatreName(entity.getTheatreName());
				theatre.setTheatreCity(entity.getTheatreCity());
				theatres.add(theatre);
				
			}
			return theatres;
			
		}
		else
			throw new TheatreNotFoundException("Incorrect Theatre Name!");
		
	}

	//PutMapping method to update values in the table by the theatreId
	@Override
	public Theatre updateTheatre(Integer theatreId, Theatre theatre) throws TheatreNotFoundException {
		
		Optional<TheatreEntity> optional = repository.findById(theatreId);
		if(optional.isPresent()) {
			
			TheatreEntity entity = optional.get();
			entity.setTheatreName(theatre.getTheatreName());
			entity.setTheatreCity(theatre.getTheatreCity());
			repository.saveAndFlush(entity);
			
			Theatre updatedTheatre = new Theatre();
			updatedTheatre.setTheatreId(entity.getTheatreId());
			updatedTheatre.setTheatreName(entity.getTheatreName());
			updatedTheatre.setTheatreCity(entity.getTheatreCity());
			return updatedTheatre;
			
		}
		else
			throw new TheatreNotFoundException("Incorrect Theatre ID");
		
	}

	//-------------------------------------------------------------------------------------------------------------------------------------->
	//PostMapping method to INSERT into the table
	@Override
	public Theatre addTheatre(Theatre theatre) {
		
		TheatreEntity entity = new TheatreEntity();
		
		entity.setTheatreName(theatre.getTheatreName());
		entity.setTheatreCity(theatre.getTheatreCity());
		
		entity = repository.saveAndFlush(entity);
		
		theatre.setTheatreId(entity.getTheatreId());
		theatre.setTheatreCity(entity.getTheatreCity());
		
		return theatre;
		
	}

	//DeleteMapping method to delete an entry from the table by its ID
	@Override
	public Boolean deleteTheatre(Integer theatreId) throws TheatreNotFoundException {
		
		Boolean result = false;
		
		try {
			repository.deleteById(theatreId);
			result = true;
		}catch(Exception e) {
			throw new TheatreNotFoundException("Incorrect theatre ID");
		}
		
		return result;
		
	}

}
