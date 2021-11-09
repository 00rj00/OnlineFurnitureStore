package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.FurnitureOrder;
import com.exception.ReportException;
import com.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController 
{
	@Autowired
	ReportService rs;

	
	@GetMapping(path = "/getAllBills")
	public ResponseEntity<List<Bill>> getBills() throws ReportException
	{
		ResponseEntity<List<Bill>> re =new ResponseEntity<List<Bill>>(rs.getAllBills(), HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path = "/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws ReportException
	{
		ResponseEntity<List<Customer>> re = new ResponseEntity<List<Customer>>(rs.getAllCustomers(), HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path = "/getAllCartDetails")
	public ResponseEntity<List<Cart>> getAllCarts() throws ReportException
	{
		ResponseEntity<List<Cart>> re = new ResponseEntity<List<Cart>>(rs.getAllCarts(), HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path = "/getAllOrderDetails")
	public ResponseEntity<List<FurnitureOrder>> getAllOrders() throws ReportException
	{
		ResponseEntity<List<FurnitureOrder>> re = new ResponseEntity<List<FurnitureOrder>>(rs.getAllOrders(), HttpStatus.OK);
		return re;
	}
}
