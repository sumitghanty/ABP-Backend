package com.mazars.in.model.transactionmodel;

import java.util.List;

import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.model.mastermodel.TileMaster;
import com.mazars.in.model.mastermodel.User;

public class LoginResponseModel {
	private Login login;
	private User user;
	/*private List<RoleToTilemapping> roleToTilemapping;
	
	private List<RoleMaster> roleMaster;*/
	
	private List<TileMaster> tileMaster;
	private MasterResponseModel masterResponseModel;
	private List<RoleMaster> roleMaster;
	private int responseCode;
	private String responseMessage;
	
	public MasterResponseModel getMasterResponseModel() {
		return masterResponseModel;
	}
	public void setMasterResponseModel(MasterResponseModel masterResponseModel) {
		this.masterResponseModel = masterResponseModel;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<TileMaster> getTileMaster() {
		return tileMaster;
	}
	public void setTileMaster(List<TileMaster> tileMaster) {
		this.tileMaster = tileMaster;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public List<RoleMaster> getRoleMaster() {
		return roleMaster;
	}
	public void setRoleMaster(List<RoleMaster> roleMaster) {
		this.roleMaster = roleMaster;
	}
	
	
	
}
