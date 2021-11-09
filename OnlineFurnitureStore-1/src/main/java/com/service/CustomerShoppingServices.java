package com.service;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.*;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.CustomerShoppingException;

@Service
public class CustomerShoppingServices implements CustomerShoppingService
{
	//Auto wiring the objects for using the JpaRepository methods
	@Autowired
	FurnitureRepository furnitureRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	CustomerRepository customerRepo;

	
	//This method will return all the furniture types that are available in DB
	@Override
	public List<Furniture> getAllFurnitures() throws CustomerShoppingException 
	{
		try 
		{
			List<Furniture> allFurniture = furnitureRepo.findAll();
			if(allFurniture != null)
			{
				return allFurniture;
			}
			else
			{
				throw new CustomerShoppingException("The Furniture table is empty");
			}
		}
		catch(Exception e)
		{
			throw new CustomerShoppingException("The Furniture table is empty");
		}
		
		
	}

	
	//This method is used to return a furniture based on its Name
	@Override
	public Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException
	{
		try 
		{
			Furniture result = furnitureRepo.findbyName(furnitureName);
			return result; 
		}
		catch (Exception e) 
		{
			throw new CustomerShoppingException("Furniture does not exist");
		}
	}

	
	//This method is to add the required furniture on to cart
	@Override
	public Cart addtoCart(Cart cart) throws CustomerShoppingException
	{
		return cartRepo.save(cart);
	}

	
	//This method is to place order for purchase
	@Override
	public FurnitureOrder placeOrder(FurnitureOrder order) throws CustomerShoppingException
	{
		return orderRepo.save(order);
	}
	
	
	//This method is for adding customer details before shopping for furniture
	@Override
	public Customer addCustomerDetails(Customer cd) 
	{
		return customerRepo.save(cd);
	}

}
