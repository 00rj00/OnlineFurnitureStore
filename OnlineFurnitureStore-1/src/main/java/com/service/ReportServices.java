package com.service;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.FurnitureOrder;
import com.exception.ReportException;
import com.repository.*;

//This is an ADMIN MODULE for the purpose of gathering reports of all the purchases and stuff
@Service
public class ReportServices implements ReportService
{
	
	//Auto wiring the objects for using the JpaRepository methods
	@Autowired
	BillRepository billRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	OrderRepository orderRepo;

	
	//This method is for getting all the Bills for reports
	@Override
	public List<Bill> getAllBills() throws ReportException 
	{		
		List<Bill> bills = billRepo.findAll();
		return bills;
	}

	//This method is for getting all the customer details
	@Override
	public List<Customer> getAllCustomers() throws ReportException 
	{
		List<Customer> customers = customerRepo.findAll();
		return customers;
	}

	//This method is for getting all the Carts that are registered
	@Override
	public List<Cart> getAllCarts() throws ReportException 
	{
		List<Cart> carts = cartRepo.findAll();
		return carts;
	}

	//This method is for getting all the Orders that are placed 
	@Override
	public List<FurnitureOrder> getAllOrders() throws ReportException 
	{
		List<FurnitureOrder> orders = orderRepo.findAll();
		return orders;
	}

}
