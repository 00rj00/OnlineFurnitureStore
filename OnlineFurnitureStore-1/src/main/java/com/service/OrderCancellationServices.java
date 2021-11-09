package com.service;

import java.util.List; 
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FurnitureOrder;
import com.exception.OrderServiceException;
import com.repository.OrderCancellationRepository;

//This module is for cancellation of an Order 
@Service
public class OrderCancellationServices implements OrderCancellationService
{
	////Auto wiring the objects for using the JpaRepository methods
	@Autowired
	OrderCancellationRepository orderCancellationRepo;
	
	//This method is for canceling the order 
	@Override
	public String deleteOrder(FurnitureOrder order) throws OrderServiceException 
	{
		List<FurnitureOrder> resultFurniture;
		try {
			resultFurniture = orderCancellationRepo.findAll();
			if (resultFurniture != null) 
			{
				orderCancellationRepo.deleteAll();
				return "All Values are deleted successfully";
			} 
			else 
			{
				throw new OrderServiceException("There is no value in the furniture");
			}
		} 
		catch (Exception e) 
		{
			throw new OrderServiceException("There is no value in the furniture");
		}
	}

	//This method is also for canceling Order but by ID
	@Override
	public String deleteOrderById(String orderId) throws OrderServiceException {
		try {
			Optional<FurnitureOrder> del = orderCancellationRepo.findById(orderId);
			if (del == null) 
			{
				throw new OrderServiceException("no user found");
			} 
			else 
			{
				orderCancellationRepo.deleteById(orderId);
				return "Order Deleted" + del;

			}
		} 
		catch (Exception e) 
		{
			throw new OrderServiceException("No order found");
		}
	}

}
