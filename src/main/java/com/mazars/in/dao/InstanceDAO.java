package com.mazars.in.dao;

import java.util.List;

import com.mazars.in.model.mastermodel.Instance;

public interface InstanceDAO {
	public void save(Instance instance);
	public void update(Instance instance);
	
	public List<Instance> list();
}
