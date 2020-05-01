package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.common.Constants;
import com.mazars.in.dao.UserDaoRepository;
import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.model.mastermodel.RoleToTilemapping;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDaoRepository userDAO;

	
	public User save(User user) {
		userDAO.save(user);
		return user;
	}

	
	public User update(User user) {
		userDAO.save(user);
		return user;
	}

	public User getUserData(String userId) {
		User user=userDAO.getUserData(userId);
		return user;
	}
	
	public List<User> list() {
		List<User> user=userDAO.list();
		return user;
	}

	
	public String delete(User user) {
		userDAO.delete(user);
		return Constants.user_Successfully_Deleted;
	}

	
	public User loginVerification(String userEmail) {
		User user=userDAO.loginVerification(userEmail);
		return user;
	}

	
	public List<RoleToTilemapping> getRoleData(User user1, List<RoleMaster> roleMaster) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/*public List<RoleToTilemapping> getRoleData(User user1,List<RoleMaster> roleMaster)
	{
		//List<RoleMaster> roleMaster =null;
		HashMap<Integer, RoleToTilemapping> tileMap  =null;
		
		if(user1!=null)
		{
			tileMap  = new HashMap<>();

			for(int i =0;i< user1.getUserToRoleMapping().size();i++) {


				for(int j =0;j< roleMaster.size();j++) {
					if(user1.getUserToRoleMapping().get(i).getRoleId() == roleMaster.get(j).getRoleMasterId()) {

						for(int k =0;k< roleMaster.get(j).getRoleToTilemapping().size();k++) {
							tileMap.put( roleMaster.get(j).getRoleToTilemapping().get(k).getId(), roleMaster.get(j).getRoleToTilemapping().get(k));
						}

					}


				}

			}
		}

	

	Iterator<Map.Entry<Integer, RoleToTilemapping>> itr = tileMap.entrySet().iterator();
	List<RoleToTilemapping> tileList = new ArrayList<RoleToTilemapping>();
	while(itr.hasNext())
	{
		Map.Entry<Integer, RoleToTilemapping> entry = itr.next();
		tileList.add(entry.getValue());
		

	} 

	return tileList;	
}
	*/

}
