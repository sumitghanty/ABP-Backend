package com.mazars.in.model.transactionmodel;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@EnableJpaAuditing
@Table(name="hotel_guest_house_booking_details")
public class HotelGuestHouseBookingDetails {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hotel_guest_housing_booking_id")
	private int hotelGuestHousingBookingId;
	@Column(name="line_item_id")
	private int lineItemId;
	@Column(name="trip_id")
	private int tripId;
	@Column(name="booking_type")
	private String bookingType;
	@Column(name="hsn_code")
	private String hSNCode;
	@Column(name="hotel_guest_house_name")
	private String hotelGuesthouseName;	
	@Column(name="amount")
	private float amount;
	@Column(name="check_in_time")
	private String checkInTime;
	@Column(name="check_out_time")
	private String checkOutTime;
	@Column(name="number_of_rooms")
	private int numberOfRooms;
	@Column(name="tied_up")
	private String tiedUp;
	@Column(name="remarks")
	private String remarks;	
	@Column(name="estimated_cost")
	private float estimatedCost;
	@Column(name="entitled_amount")
	private float entitledAmount;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="hotel_guest_housing_booking_id")
	private Set<SelectedHotel> selectedHotel;

	public int getHotelGuestHousingBookingId() {
		return hotelGuestHousingBookingId;
	}

	public void setHotelGuestHousingBookingId(int hotelGuestHousingBookingId) {
		this.hotelGuestHousingBookingId = hotelGuestHousingBookingId;
	}

	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String gethSNCode() {
		return hSNCode;
	}

	public void sethSNCode(String hSNCode) {
		this.hSNCode = hSNCode;
	}

	public String getHotelGuesthouseName() {
		return hotelGuesthouseName;
	}

	public void setHotelGuesthouseName(String hotelGuesthouseName) {
		this.hotelGuesthouseName = hotelGuesthouseName;
	}
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getTiedUp() {
		return tiedUp;
	}

	public void setTiedUp(String tiedUp) {
		this.tiedUp = tiedUp;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public float getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(float estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public float getEntitledAmount() {
		return entitledAmount;
	}

	public void setEntitledAmount(float entitledAmount) {
		this.entitledAmount = entitledAmount;
	}

	public Set<SelectedHotel> getSelectedHotel() {
		return selectedHotel;
	}

	public void setSelectedHotel(Set<SelectedHotel> selectedHotel) {
		this.selectedHotel = selectedHotel;
	}

	

	
	
	
}
