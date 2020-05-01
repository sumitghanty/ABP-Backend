package  com.mazars.in.dao;

import java.util.List;

import com.mazars.in.model.mastermodel.TripMaster;


public interface TripMasterDAO {

	public void save(TripMaster p);
	public void update(TripMaster p);
	
	public List<TripMaster> list();
	
}
