package com.mazars.in.model.transactionmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import com.mazars.in.model.mastermodel.TripMaster;

@Entity
@Table(name="tbl_line_item")
@OptimisticLocking(type = OptimisticLockType.NONE)

public class LineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="item_id")
	private String itemId;
	
	@Column(name="item_total")
	private double itemTotal;
	
	@Column(name="quantity")
	private int quantity;
	
	//@ManyToOne
	//@JoinColumn(name="cart_id", nullable=false)
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "cart_id", updatable = false, insertable = false, nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id", nullable=false)
	private TripMaster trip;
	
	//Hibernate requires no-args constructor
	public LineItem(){}
	
	public LineItem(String itemId, double total, int qty, TripMaster c){
		this.itemId=itemId;
		this.itemTotal=total;
		this.quantity=qty;
		this.trip=c;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public TripMaster getCart1() {
		return trip;
	}
	public void setCart1(TripMaster cart) {
		this.trip = cart;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
