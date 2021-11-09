package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FurnitureOrder;
import com.exception.OrderServiceException;
import com.service.OrderCancellationServices;

@RestController
@RequestMapping("/api/orderCancellation")
public class OrderCancellationController 
{
	@Autowired 
	OrderCancellationServices ocs;
	
	@DeleteMapping(path = "/deleteFurniture/{orderId}")
	public String deleteFurnitureByID(@PathVariable("orderId") String orderId) throws OrderServiceException 
	{
		ocs.deleteOrderById(orderId);
		return "Order cancelled successfully" + orderId;
	}
	
	
	@DeleteMapping(path = "/deleteOrder")
	public String deleteOrder(FurnitureOrder order) throws OrderServiceException 
	{
		String o = ocs.deleteOrder(order);
		return "Deletion Completed for" + o;
	}

}
