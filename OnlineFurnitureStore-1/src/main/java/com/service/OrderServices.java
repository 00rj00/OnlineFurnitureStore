package com.service;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FurnitureOrder;
import com.exception.UserNotFoundException;
import com.repository.OrderRepository;

@Service
public class OrderServices implements OrderService
{
	//Auto wiring the objects for using the JpaRepository methods
	@Autowired
	OrderRepository orderRepo;

	//This method is for displaying all the orders
	@Override
	public List<FurnitureOrder> getAllOrders() {
		List<FurnitureOrder> getOrders = orderRepo.findAll();
		return getOrders;
	}

	//This method is for updating Order
	@Override
	public FurnitureOrder updateOrder(FurnitureOrder order) throws UserNotFoundException {
		if ((order != null)) 
		{			
			FurnitureOrder updateUserOrder = orderRepo.save(order);
			return updateUserOrder;
		} 
		else 
		{
			throw new UserNotFoundException("Order does not exist");
		}
	}


	

	
	

}
