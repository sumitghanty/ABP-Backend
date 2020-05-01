package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.DomesticIataMapping;


public interface DomesticIataMappingService {
	
	public String save(DomesticIataMapping domesticIataMapping);
	public String update(DomesticIataMapping domesticIataMapping);
	
	public List<DomesticIataMapping> list();
	public String delete(DomesticIataMapping domesticIataMapping);

}
