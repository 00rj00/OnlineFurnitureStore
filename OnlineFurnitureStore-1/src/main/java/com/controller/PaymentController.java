package com.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Bill;
//import com.entity.Card;
import com.service.PaymentServices;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/payment")
public class PaymentController 
{
	@Autowired
	private PaymentServices pays;
	
	@GetMapping(path = "/getBillByIdeDetalis/{billNo}")
	public ResponseEntity<Bill> getBillById(@RequestParam long billNo) throws Exception 
	{
		ResponseEntity<Bill> re = new ResponseEntity<Bill>(pays.getBillById(billNo), HttpStatus.OK);
		return re;
	}
	
	
	@PutMapping("/payByCash/{orderId}")
	public ResponseEntity<String> payByCash(@RequestParam double amount,@RequestParam double price) throws Exception {
		double change = pays.payByCash(amount,price);
		if (change == 0) 
		{
			return new ResponseEntity<String>("Your transaction is completed.. ", HttpStatus.OK);
		} 
		else if (change < 0) 
		{
			return new ResponseEntity<String>("Please take the change: " + change, HttpStatus.OK);
		} 
		else 
		{
			return new ResponseEntity<String>("Your Due amount is: " + change, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addBillDetails")
	public ResponseEntity<Bill> addBillDetails(Bill bill)
	{
		Bill b = pays.addBillDetails(bill);
		ResponseEntity<Bill> re = new ResponseEntity<Bill>(b,HttpStatus.OK);
		return re;
	}

}
