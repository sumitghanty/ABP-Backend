package com.mazars.in.model.mmt.hotelmodel;

//import java.math.BigInteger;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tbl_city_master")
//@JsonIgnoreProperties(ignoreUnknown=true)
public class CityMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="city_id")
	private String cityid;
	@Column(name="country_name")
	private String countryName;	
	@Column(name="city_name")
	private String cityName;
	@Column(name="state_name")
	private String stateName;
	@Column(name="country_code")
	private String countryCode;
	
		public CityMaster(HashMap<String, CityMaster> data)
	{
	
		
	}
	
	public CityMaster() {
			super();
		}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	

	

}

