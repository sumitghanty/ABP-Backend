package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.TravelEntitlement;
@Repository
public interface TravelEntitlementDaoRepository extends JpaRepository<TravelEntitlement, Integer>{
	@Query("SELECT t FROM TravelEntitlement t where t.organizationID =?1 and t.verticalID =?2 and t.categoryID =?3 and t.usergroupID =?4")
	public List<TravelEntitlement> findByorgvertcatid(@Param("orgid") int orgid,@Param("verid") int verid,@Param("catid") int catid,@Param("grpid") int grpid);

}
