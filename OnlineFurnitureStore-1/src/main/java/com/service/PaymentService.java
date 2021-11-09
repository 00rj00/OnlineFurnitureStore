package com.service;

import com.entity.Bill; 
//import com.entity.Card;
//import com.entity.FurnitureOrder;

public interface PaymentService {
	Bill getBillById(long billNo);
	double payByCash(double amount,double price) throws Exception;
	//Card payByCard(Card card) throws Exception;
	Bill addBillDetails(Bill bill);

}
