package com.mazars.in.model.mastermodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="tbl_role_to_tilemapping")
public class RoleToTilemapping implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="tile_id")
	private int tileId;
	@Column(name="role_master_id")
	private int roleMasterId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTileId() {
		return tileId;
	}
	public void setTileId(int tileId) {
		this.tileId = tileId;
	}
	public int getRoleMasterId() {
		return roleMasterId;
	}
	public void setRoleMasterId(int roleMasterId) {
		this.roleMasterId = roleMasterId;
	}
	
	
	
	
	
}
