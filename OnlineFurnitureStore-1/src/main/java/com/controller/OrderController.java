package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FurnitureOrder;
import com.exception.UserNotFoundException;
import com.service.OrderServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/Order")
public class OrderController 
{
	@Autowired
	OrderServices os;
	
	
	@GetMapping(path = "/getAllOrderDetails")
	public ResponseEntity<List<FurnitureOrder>> getAllOrderDetails() throws UserNotFoundException 
	{
		List<FurnitureOrder> allOrders = os.getAllOrders();
		ResponseEntity<List<FurnitureOrder>> re = new ResponseEntity<List<FurnitureOrder>>(allOrders, HttpStatus.OK);
		return re;
	}
	
	
	@PutMapping(path = "/updateOrder")
	public String updateOrder(@RequestBody FurnitureOrder order) throws UserNotFoundException 
	{
		FurnitureOrder user = os.updateOrder(order);
		return "Order Updated Successfully"+user;
	}
	
	
	


}
