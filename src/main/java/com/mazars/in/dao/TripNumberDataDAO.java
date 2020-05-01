package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.transactionmodel.TripNumberData;

@Repository
public interface TripNumberDataDAO extends JpaRepository<TripNumberData, Integer>{

	
	@Query("select t from TripNumberData t where t.type=:type and t.year=:year order by t.number desc")
	public List<TripNumberData> getLatestTripNumberDataInDb(@Param("type") String type,@Param("year") String year);
	//public void savetripNumberDataInDb(TripNumberData tripNumberData);
	
}
