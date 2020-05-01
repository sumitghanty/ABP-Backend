package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.DomesticIataMapping;

@Repository
public interface DomesticIataMappingDAO extends JpaRepository<DomesticIataMapping, Integer>{
	
	//public void save(DomesticIataMapping domesticIataMapping);
	//public void update(DomesticIataMapping domesticIataMapping);
	
	
	@Query("select d from DomesticIataMapping d")
	public List<DomesticIataMapping> list();
	//public void delete(DomesticIataMapping domesticIataMapping);


}
