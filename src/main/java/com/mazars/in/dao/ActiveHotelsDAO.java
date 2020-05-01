package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.ActiveHotels;

@Repository
public interface ActiveHotelsDAO extends JpaRepository<ActiveHotels, Integer>{
	
	//public  save(ActiveHotels activeHotels);
	//public void update(ActiveHotels activeHotels);
	
	@Query("select a from ActiveHotels a")
	public List<ActiveHotels> list();
	//public void delete(ActiveHotels activeHotels);


}
