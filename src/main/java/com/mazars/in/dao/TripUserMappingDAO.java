package com.mazars.in.dao;

import com.mazars.in.model.transactionmodel.TripUserMapping;

public interface TripUserMappingDAO {
	public void save(TripUserMapping tripUserMapping);
	public void update(TripUserMapping tripUserMapping);
	
	public TripUserMapping list();
	public void delete(TripUserMapping tripUserMapping);

}
