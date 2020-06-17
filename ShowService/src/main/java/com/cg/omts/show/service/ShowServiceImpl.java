/**********************************************************************************************************************************
 -File Name         :   Show Service
 -Author            :   Sandra Binoy
 -Creation Date     :   13-06-2020
 -Description       :   The implementation of the IShowService class
 **********************************************************************************************************************************/
package com.cg.omts.show.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.show.dao.IShowRepository;
import com.cg.omts.show.entity.ShowEntity;
import com.cg.omts.show.exception.ShowNotFoundException;
import com.cg.omts.show.model.Show;

@Service
public class ShowServiceImpl implements IShowService {
	
	@Autowired
	private IShowRepository repository;

	//The GetMapping method to SELECT all the rows and return them
	@Override
	public List<Show> getAllShows() {
		
		List<ShowEntity> entityList = repository.findAll();
		List<Show> shows = new ArrayList<>();
		for(ShowEntity entity:entityList) {
			
			Show show = new Show();
			show.setShowId(entity.getShowId());
			show.setShowName(entity.getShowName());
			show.setTheatreId(entity.getTheatreId());
			show.setStartTime(entity.getStartTime());
			show.setEndTime(entity.getEndTime());
			show.setMovieName(entity.getMovieName());
			shows.add(show);
			
		}
		return shows;
		
	}

	//The GetMapping method to get show(s) by its name and return it
	@Override
	public List<Show> getShowByName(String showName) throws ShowNotFoundException {
		
		List<Show> shows = new ArrayList<>();
		
		List<ShowEntity> entityList = repository.findAllByShowName(showName);
		
		if(!entityList.isEmpty()) {
			
			for(ShowEntity entity: entityList) {
				
				Show show = new Show();
				show.setShowId(entity.getShowId());
				show.setShowName(entity.getShowName());
				show.setTheatreId(entity.getTheatreId());
				show.setStartTime(entity.getStartTime());
				show.setEndTime(entity.getEndTime());
				show.setMovieName(entity.getMovieName());
				shows.add(show);
				
			}

			return shows;
		}
		else
			throw new ShowNotFoundException("Incorrect Show Name!");
		
		
	}

	//The PutMapping method to UPDATE values in the table by their showId
	@Override
	public Show updateShow(Integer showId, Show show) throws ShowNotFoundException {
		
		Optional<ShowEntity> optional = repository.findById(showId);
		if(optional.isPresent()) {
			
			ShowEntity entity = optional.get();
			entity.setShowName(show.getShowName());
			entity.setTheatreId(show.getTheatreId());
			entity.setStartTime(show.getStartTime());
			entity.setEndTime(show.getEndTime());
			entity.setMovieName(show.getMovieName());
			repository.saveAndFlush(entity);
			
			Show updatedShow = new Show();
			updatedShow.setShowId(entity.getShowId());
			updatedShow.setShowName(entity.getShowName());
			updatedShow.setTheatreId(entity.getTheatreId());
			updatedShow.setStartTime(entity.getStartTime());
			updatedShow.setEndTime(entity.getEndTime());
			updatedShow.setMovieName(entity.getMovieName());
			
			return updatedShow;
			
		}
		else
			throw new ShowNotFoundException("Incorrect Show ID");
		
	}

	//The PostMapping method to INSERT into the table
	@Override
	public Show addShow(Show show) {
		
		ShowEntity entity = new ShowEntity();
		
		entity.setShowName(show.getShowName());
		entity.setTheatreId(show.getTheatreId());
		entity.setStartTime(show.getStartTime());
		entity.setEndTime(show.getEndTime());
		entity.setMovieName(show.getMovieName());
		
		ShowEntity showEntity = repository.saveAndFlush(entity);
		
		show.setShowId(showEntity.getShowId());
		
		return show;
		
	}

	//The DeleteMapping method to delete an entry from the table by its ID
	@Override
	public Boolean deleteShow(Integer showId) throws ShowNotFoundException {
		
		Boolean result = false;
		
		try {
			repository.deleteById(showId);
			result = true;
		}catch(Exception e) {
			throw new ShowNotFoundException("Incorrect Show ID");
		}
		
		return result;
		
	}

}
