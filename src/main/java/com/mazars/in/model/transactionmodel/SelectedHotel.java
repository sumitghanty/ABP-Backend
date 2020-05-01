package com.mazars.in.model.transactionmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@EnableJpaAuditing
@OptimisticLocking(type = OptimisticLockType.NONE)
@Table(name="tbl_selected_hotel")
public class SelectedHotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="selected_hotel_id")
	private int selectedHotelId;
	@Column(name="price")
	private int price;
	@Column(name="guest_rating")
	private float guestRating;
	@Column(name="star_rating")
	private float starRating;
	@Column(name="hotel_picture")
	private String hotelPicture;
	@Column(name="name")
	private String name;
	
	@Lob
	@Column(name="hotel_data",columnDefinition="blob")
	private String hotelData;
	@Column(name="hotel_guest_housing_booking_id")
	private int hotelGuestHousingBookingId;
	@Column(name="selection_type")
	private String selectionType;
	@Column(name="user_rating")
	private String userRating;
	
	@Lob
	@Column(name="hotel_amenities",columnDefinition="blob")
	private String hotelAmenities;
	
	public int getSelectedHotelId() {
		return selectedHotelId;
	}
	public void setSelectedHotelId(int selectedHotelId) {
		this.selectedHotelId = selectedHotelId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getGuestRating() {
		return guestRating;
	}
	public void setGuestRating(float guestRating) {
		this.guestRating = guestRating;
	}
	public float getStarRating() {
		return starRating;
	}
	public void setStarRating(float starRating) {
		this.starRating = starRating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotelData() {
		return hotelData;
	}
	public void setHotelData(String hotelData) {
		this.hotelData = hotelData;
	}
	public int getHotelGuestHousingBookingId() {
		return hotelGuestHousingBookingId;
	}
	public void setHotelGuestHousingBookingId(int hotelGuestHousingBookingId) {
		this.hotelGuestHousingBookingId = hotelGuestHousingBookingId;
	}
	public String getSelectionType() {
		return selectionType;
	}
	public void setSelectionType(String selectionType) {
		this.selectionType = selectionType;
	}
	public String getHotelPicture() {
		return hotelPicture;
	}
	public void setHotelPicture(String hotelPicture) {
		this.hotelPicture = hotelPicture;
	}
	public String getUserRating() {
		return userRating;
	}
	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	public String getHotelAmenities() {
		return hotelAmenities;
	}
	public void setHotelAmenities(String hotelAmenities) {
		this.hotelAmenities = hotelAmenities;
	}
	
	
	
}
