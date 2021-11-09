package com.service;

import java.util.List;

import com.exception.CustomerShoppingException;
import com.entity.*;

public interface CustomerShoppingService {
	
	List<Furniture> getAllFurnitures() throws CustomerShoppingException;
	
	Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException;

	Cart addtoCart(Cart cart) throws CustomerShoppingException;
	
	FurnitureOrder placeOrder(FurnitureOrder order) throws CustomerShoppingException;
	
	Customer addCustomerDetails(Customer cd);

}
