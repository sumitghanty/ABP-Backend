package com.mazars.in.dao;

import java.util.List;

import com.mazars.in.model.transactionmodel.LineItemMaster;

public interface LineItemMasterDAO {

	public void save(LineItemMaster lineItemMaster);
	public void update(LineItemMaster lineItemMaster);
	
	public List<LineItemMaster> list();
	public void delete(LineItemMaster lineItemMaster);

}
