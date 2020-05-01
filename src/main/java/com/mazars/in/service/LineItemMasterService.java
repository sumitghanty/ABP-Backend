package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.transactionmodel.LineItemMaster;


public interface LineItemMasterService {

	public String save(LineItemMaster lineItemMaster);
	public String update(LineItemMaster lineItemMaster);
	
	public List<LineItemMaster> list();
	public String delete(LineItemMaster lineItemMaster);
}
