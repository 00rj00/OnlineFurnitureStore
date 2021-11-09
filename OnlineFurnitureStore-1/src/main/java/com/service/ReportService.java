package com.service;

import java.util.List ;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.FurnitureOrder;
import com.exception.ReportException;

public interface ReportService {

	List<Bill> getAllBills() throws ReportException;
	List<Customer> getAllCustomers() throws ReportException;
	List<Cart> getAllCarts() throws ReportException;
	List<FurnitureOrder> getAllOrders() throws ReportException;
}
