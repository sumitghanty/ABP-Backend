package com.mazars.in.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mazars.in.model.mastermodel.ActiveHotels;


public interface ActiveHotelsService {
	
	public String save(ActiveHotels activeHotels);
	public String update(ActiveHotels activeHotels);	
	public List<ActiveHotels> list();
	public String delete(ActiveHotels activeHotels);

}
