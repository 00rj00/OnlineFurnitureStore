package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.*;
import com.exception.OrderServiceException;
import com.exception.UserNotFoundException;
import com.service.OrderService;

@SpringBootTest
public class OrderServiceTests 
{
	@Autowired
	private OrderService service;
	
	@Test
	void geAllFurnitureOrder() throws OrderServiceException{
		assertNotNull(service.getAllOrders());
	}
	
	@Test
	void updateOrder() throws UserNotFoundException{
		FurnitureOrder order=new FurnitureOrder();
		order.setOrderId("12");
		order.setPrice(4545.66);
		order.setQuanity(4);
		order.setStatus("pending");
		order.setAmount(4556.565);
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(4);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("Wingback Chair");
		furniture.setFurnitureName("Chair");
		order.setFurniture(furniture);
		Customer customer = new Customer();
		customer.setName("angel");
		customer.setContactNo("9443204173");
		customer.setEmail("angel@gmail.com");
		customer.setUId(5);
		customer.setUsername("agnel");
		customer.setPassword("angel");
		customer.setRole("admin");
		Address address = new Address();
		address.setAddressId(11);
		address.setCity("KVP");
		address.setCountry("IN");
		address.setState("TN");
		address.setPincode("628501");
		customer.setAddress(address);
		order.setCustomer(customer);
		assertEquals(order.getQuanity(), service.updateOrder( order).getQuanity());
	}

}
