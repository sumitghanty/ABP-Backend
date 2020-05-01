package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.TravelCityEntitlement;
@Repository
public interface TravelCityEntitlementDaoRepository extends JpaRepository<TravelCityEntitlement, Integer> {
	@Query("SELECT t FROM TravelCityEntitlement t where t.cityCategoryId =?1 and t.entitlementid =?2")
	public List<TravelCityEntitlement> findBycategoryentitlementid(@Param("catid") int catid,@Param("entid") int entid);
}
