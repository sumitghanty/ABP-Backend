package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.RoleMasterDAO;
import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.model.mastermodel.TileMaster;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.service.RoleMasterService;

@Service
@Transactional
public class RoleMasterServiceImpl  implements RoleMasterService{
	
@Autowired	
private RoleMasterDAO roleMasterDAO;


@Override
public RoleMaster save(RoleMaster roleMaster) {
	
	return roleMasterDAO.save(roleMaster);
}

@Override
public RoleMaster update(RoleMaster roleMaster) {
	
	return roleMasterDAO.save(roleMaster);
	
}

@Override
public List<RoleMaster> roleMasterList() {
	List<RoleMaster> roleMaster=roleMasterDAO.roleMasterList();
	return roleMaster;
}

@Override
public void delete(RoleMaster roleMaster) {
	
	roleMasterDAO.delete(roleMaster);
}
@Override
public List<TileMaster> getTilesForUser(User user)
{
	int userId=user.getUserId();
	List<TileMaster> lTile=roleMasterDAO.getTilesForUser(userId);
	for(TileMaster tm:lTile) {
		int tileId=tm.getTileId();
		int count=roleMasterDAO.getCount(userId, tileId);
		tm.setCount(count);
	}
	
	return lTile;
	

}

}
