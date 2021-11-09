package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.CustomerShoppingException;
import com.service.CustomerShoppingServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/CustomerShopping")
public class CustomerShoppingController 
{
	@Autowired
	CustomerShoppingServices customerservice;
	
	
	@GetMapping(path = "/getAllFurnitureDetails",produces = "application/json")
	public ResponseEntity<List<Furniture>> getAllFurnitureDetails() throws CustomerShoppingException 
	{
		List<Furniture> resultFurniture = customerservice.getAllFurnitures();
		ResponseEntity<List<Furniture>> re = new ResponseEntity<List<Furniture>>(resultFurniture, HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path = "/getFurnitureDetails/{furnitureName}",produces = "application/json")
	public ResponseEntity<Furniture> getFurniture(@PathVariable("furnitureName") String furnitureName) throws CustomerShoppingException 
	{
		Furniture resultFurniture=customerservice.getFurnitureByName(furnitureName);
		ResponseEntity<Furniture> re = new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
		return re;
	}
	
	
	@PostMapping(path = "/addToCart",produces = "application/json")
	public String addFurniture(@RequestBody Cart cart) throws CustomerShoppingException 
	{
		Cart c = customerservice.addtoCart(cart);
		return "furniture added to cart successfully " + c;
	}
	
	
	@PostMapping(path = "/placeOrder", produces = "application/json")
	public String placeOrder(@RequestBody FurnitureOrder furnitureorder) throws CustomerShoppingException {
		FurnitureOrder order = customerservice.placeOrder(furnitureorder);
		return "order placed successfully " + order;

	}
	
	
	@PostMapping(path="/addCustomerdetails")
	public  ResponseEntity<Customer> addCustomerDetails(@RequestBody Customer customer) throws CustomerShoppingException {
		Customer c1 = customerservice.addCustomerDetails(customer);
		ResponseEntity<Customer> re = new ResponseEntity<Customer>(c1, HttpStatus.OK);
		return re;
	}

}
