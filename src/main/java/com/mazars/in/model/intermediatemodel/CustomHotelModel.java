package com.mazars.in.model.intermediatemodel;

public class CustomHotelModel {

	
	
	private int price;
	private float guestRating;
	private float starRating;
	private String[] type;
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public float getStarRating() {
		return starRating;
	}
	public void setStarRating(float starRating) {
		this.starRating = starRating;
	}
	private String imageUrl;
	private String name;
	private String hotelData;
	public String getHotelData() {
		return hotelData;
	}
	public void setHotelData(String hotelData) {
		this.hotelData = hotelData;
	}
	private String[]  amenities;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getAmenities() {
		return amenities;
	}
	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}
	
	
}
