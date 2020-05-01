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

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@OptimisticLocking(type = OptimisticLockType.NONE)
@EnableJpaAuditing
@Table(name="tbl_line_item_master")
public class LineItemMaster {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="line_item_id")
	private int lineItemId;
	@Column(name="line_item_type")
	private String lineItemtype;
	@Column(name="trip_id")
	private int tripId;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="line_item_id")
	private Set<FlightTrainBookingDetails> flightOrTrainBooking;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="line_item_id")
	private Set<HotelGuestHouseBookingDetails> hotelGuestHouseBookingDetaills;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="line_item_id")
	private Set<OtherBookingDetails> otherInvoiceDetails;

	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public String getLineItemtype() {
		return lineItemtype;
	}

	public void setLineItemtype(String lineItemtype) {
		this.lineItemtype = lineItemtype;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public Set<FlightTrainBookingDetails> getFlightOrTrainBooking() {
		return flightOrTrainBooking;
	}

	public void setFlightOrTrainBooking(Set<FlightTrainBookingDetails> flightOrTrainBooking) {
		this.flightOrTrainBooking = flightOrTrainBooking;
	}

	public Set<HotelGuestHouseBookingDetails> getHotelGuestHouseBookingDetaills() {
		return hotelGuestHouseBookingDetaills;
	}

	public void setHotelGuestHouseBookingDetaills(Set<HotelGuestHouseBookingDetails> hotelGuestHouseBookingDetaills) {
		this.hotelGuestHouseBookingDetaills = hotelGuestHouseBookingDetaills;
	}

	public Set<OtherBookingDetails> getOtherInvoiceDetails() {
		return otherInvoiceDetails;
	}

	public void setOtherInvoiceDetails(Set<OtherBookingDetails> otherInvoiceDetails) {
		this.otherInvoiceDetails = otherInvoiceDetails;
	}

	
	
	

}
