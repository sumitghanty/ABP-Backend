package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.transactionmodel.TripCreation;

@Repository
public interface TripCreationDAO  extends JpaRepository<TripCreation, Integer>{

	
	//public TripCreation save(TripCreation instance);
	//public TripCreation update(TripCreation instance);
	
	//public List<TripCreation> list();
	/*@Query(value="select * from TripCreation t where t.pendingWithEmail=:emailId",
			countQuery="select count(*) from TripCreation t where t.pendingWithEmail=:emailId",
			nativeQuery=true)
	public List<TripCreation> tripListByEmailId(@Param("emailId") String emailId);*/
	
	@Query("select t from TripCreation t where t.pendingWithEmail= ?1")
	public List<TripCreation> tripListByEmailId(String emailId);
	
	@Query("select t from TripCreation t where t.tripNumber= ?1")
	public TripCreation getTripDetailsByTripNumber(String tripNumber);
	//public void delete(TripCreation instance);
	
	
	//List<TripCreation> findByEmployeeId(int employeeId);
	
	
}
