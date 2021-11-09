package com.service;

import java.util.List; 

import com.entity.*;
import com.exception.UserNotFoundException;

public interface OrderService {
	
	List<FurnitureOrder> getAllOrders() ;
	//FurnitureOrder getOrderByStatus(String status);
	FurnitureOrder updateOrder(FurnitureOrder order) throws UserNotFoundException;
	//FurnitureOrder updateOrderById(String orderId,FurnitureOrder order) throws UserNotFoundException;
}
