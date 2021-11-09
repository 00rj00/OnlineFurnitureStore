package com.service;

import com.entity.*;
import com.exception.OrderServiceException; 


public interface OrderCancellationService {
	String deleteOrder(FurnitureOrder order) throws OrderServiceException ;
	String deleteOrderById(String orderId) throws OrderServiceException ;

}
