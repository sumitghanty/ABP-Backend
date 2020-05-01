package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.transactionmodel.AdvancePayment;

public interface AdvancePaymentService {
	public void save(AdvancePayment advancePayment);
	public void update(AdvancePayment advancePayment);
	
	public List<AdvancePayment> advancePaymentList();
	
	
	public void delete(AdvancePayment advancePayment);
	
	
	
}
