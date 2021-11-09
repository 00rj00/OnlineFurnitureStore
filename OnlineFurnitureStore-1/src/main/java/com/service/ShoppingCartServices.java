package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.exception.ShoppingCartException;
import com.repository.CartRepository;

@Service
public class ShoppingCartServices implements ShoppingCartService
{

	//Auto wiring the objects for using the JpaRepository methods
	@Autowired
	CartRepository cartRepo;
	
	//This method is for returning all the registered carts
	@Override
	public List<Cart> getAllCarts() throws ShoppingCartException 
	{
		List<Cart> cartTemp = cartRepo.findAll();
		
		if (cartTemp.isEmpty()) 
		{
			throw new ShoppingCartException("Cart not found");
		} 
		else 
		{
			List<Cart> getAllCarts = cartRepo.findAll();
			return getAllCarts;
		}
	}

	//This method is for getting cart based on its ID
	@Override
	public Cart getCartById(int cartId) throws ShoppingCartException 
	{
		Optional<Cart> cartTemp = cartRepo.findById(cartId);
		if (cartTemp.isPresent() == false) 
		{
			throw new ShoppingCartException("CartId does not exist");
		} 
		else 
		{
			Cart getCart = cartRepo.findById(cartId).orElse(null);
			return getCart;
		}
	}

	
	//This method is for updating cart details based on its ID
	@Override
	public Cart updateCartById(int cartId, Cart cart) throws ShoppingCartException
	{
		Optional<Cart> cartTemp = cartRepo.findById(cartId);
		if (cartTemp.isPresent() == false) 
		{
			throw new ShoppingCartException("Cart does not exist");
		} 
		else 
		{
			Cart updcart = cartRepo.save(cart);
			return updcart;
		}
		
	}

	//Deletion of cart
	@Override
	public String deleteCart(Cart cart) throws ShoppingCartException 
	{
		List<Cart> cartTemp = cartRepo.findAll();
		if (cartTemp.isEmpty()) 
		{
			throw new ShoppingCartException("Cart not found");
		} 
		else 
		{
			cartRepo.deleteAll();
			return "All carts deleted";
		}
	}

	//Deletion based on its ID
	@Override
	public String deleteCartById(int cartId) throws ShoppingCartException
	{
		List<Cart> cartTemp = cartRepo.findAll();
		if (cartTemp.isEmpty()) 
		{
			throw new ShoppingCartException("Cart not found");
		} 
		else 
		{
			cartRepo.deleteById(cartId);;
			return "Cart deleted Successfuly";
		}
	}

}
