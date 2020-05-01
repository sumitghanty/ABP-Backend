package com.mazars.in.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mazars.in.model.mastermodel.TileMaster;


public interface TileMasterService {
	public String save(List<TileMaster> master);
	public List<TileMaster> list();
}
