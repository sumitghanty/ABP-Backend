package com.mazars.in.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.model.mastermodel.TileMaster;
import com.mazars.in.model.mastermodel.User;
@Repository
public interface RoleMasterDAO extends JpaRepository<RoleMaster, Integer>{
	
	//public RoleMaster save(RoleMaster roleMaster);
	
	//public RoleMaster update(RoleMaster roleMaster);
	
	@Query("select r from RoleMaster r")
	public List<RoleMaster> roleMasterList();
	//public List<Location> locationListByEmailId(String emailId);
	
	//public void delete(RoleMaster roleMaster);
	
	
	@Query("From TileMaster tm where tm.tileId IN(\r\n" + 
			"SELECT tileId FROM RoleToTilemapping c \r\n" + 
			"where c.roleMasterId IN (SELECT um.roleId\r\n" + 
			"		FROM User u\r\n" + 
			"		LEFT JOIN UserToRoleMapping um\r\n" + 
			"		ON u.userId = um.userId where u.userId=?1))")
	public List<TileMaster> getTilesForUser(int userId);
	
	@Query("SELECT count(*) FROM UserToRoleMapping trm INNER JOIN RoleToTilemapping trt on trm.roleId=trt.roleMasterId where trm.userId=?1 and trt.tileId=?2")
	public int getCount(int userid,int tileid);
	
}



/*List<TileMaster> tileMaster=null;
try
{
   

Session session = this.sessionFactory.openSession();
Query query = session.createQuery("FROM RoleToTilemapping c \r\n" + 
		"		where c.roleMasterId IN (SELECT roleId\r\n" + 
		"		FROM User\r\n" + 
		"		LEFT JOIN UserToRoleMapping\r\n" + 
		"		ON User.userId = UserToRoleMapping.userId where User.userId=1\r\n" + 
		"		)");

Query query = session.createQuery("FROM User u\r\n" + 
		"		LEFT JOIN UserToRoleMapping um\r\n" + 
		"		ON u.userId = um.userId where u.userId=1");

Query query = session.createQuery("FROM RoleToTilemapping c \r\n" + 
"		where c.roleMasterId IN (SELECT um.roleId\r\n" + 
"		FROM User u\r\n" + 
"		LEFT JOIN UserToRoleMapping um\r\n" + 
"		ON u.userId = um.userId where u.userId=1\r\n"+")");


Query query = session.createQuery("From TileMaster tm where tm.tileId IN(\r\n" + 
		"SELECT tileId FROM RoleToTilemapping c \r\n" + 
		"where c.roleMasterId IN (SELECT um.roleId\r\n" + 
		"		FROM User u\r\n" + 
		"		LEFT JOIN UserToRoleMapping um\r\n" + 
		"		ON u.userId = um.userId where u.userId=:user_id))");

Query query = session.createQuery("select tileId FROM RoleToTileMapping c \r\n" + 
		"where c.roleMasterId IN (select u.roleId\r\n" + 
		"		FROM User u\r\n" + 
		"		LEFT JOIN UserToRoleMapping um\r\n" + 
		"		ON u.userId = um.userId where u.userId=:user_id)");



query.setParameter("user_id", user1.getUserId());



tileMaster = query.list();
for(TileMaster tmp:tileMaster){
	
	Query queryForCount = session.createQuery("SELECT count(*) FROM UserToRoleMapping trm INNER JOIN RoleToTilemapping trt on trm.roleId=trt.roleMasterId where trm.userId=:user_ID and trt.tileId=:tile_ID");
			
	queryForCount.setParameter("user_ID", user1.getUserId());
	queryForCount.setParameter("tile_ID", tmp.getTileId());	
	
    tmp.setCount(Integer.parseInt(queryForCount.list().get(0).toString()));			

}

session.close();
		
		
logger.info("size"+tileMaster.get(0).getTileId());






}
catch(Exception e)
{
logger.info("error in list method"+e.toString());   
}


return tileMaster;
*/