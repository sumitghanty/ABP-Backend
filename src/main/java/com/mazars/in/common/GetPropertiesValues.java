package com.mazars.in.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="masterdata")
public class GetPropertiesValues {
	 private String masterdata;
	 private String mappingdata;
	  private String archive;
	public String getMasterdata() {
		return masterdata;
	}
	public void setMasterdata(String masterdata) {
		this.masterdata = masterdata;
	}
	public String getMappingdata() {
		return mappingdata;
	}
	public void setMappingdata(String mappingdata) {
		this.mappingdata = mappingdata;
	}
	public String getArchive() {
		return archive;
	}
	public void setArchive(String archive) {
		this.archive = archive;
	}
	 	 
}
