package com.mazars.in.model.transactionmodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_tripnumberdata")
public class TripNumberData {
@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private int id;
	@Column(name="type")
	private String type;
	@Column(name="year")
	private String year;
	@Column(name="number")
	private String number;
	@Column(name="s_trip_number")
	private String sTripNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getsTripNumber() {
		return sTripNumber;
	}
	public void setsTripNumber(String sTripNumber) {
		this.sTripNumber = sTripNumber;
	}
	
	
	

}

