package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.EventMaster;

public interface EventMasterService {

	public void save(EventMaster eventMaster);
	public void update(EventMaster eventMaster);
	public List<EventMaster> eventMasterList();
	public void delete(EventMaster eventMaster);
}
