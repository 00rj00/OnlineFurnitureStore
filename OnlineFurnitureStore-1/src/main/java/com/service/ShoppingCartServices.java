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

	@Autowired
	CartRepository cr;
	
	
	@Override
	public List<Cart> getAllCarts() throws ShoppingCartException 
	{
		List<Cart> cartTemp = cr.findAll();
		
		if (cartTemp.isEmpty()) 
		{
			throw new ShoppingCartException("Cart not found");
		} 
		else 
		{
			List<Cart> getAllCarts = cr.findAll();
			return getAllCarts;
		}
	}

	@Override
	public Cart getCartById(int cartId) throws ShoppingCartException 
	{
		Optional<Cart> cartTemp = cr.findById(cartId);
		if (cartTemp.isPresent() == false) 
		{
			throw new ShoppingCartException("CartId does not exist");
		} 
		else 
		{
			Cart getCart = cr.findById(cartId).orElse(null);
			return getCart;
		}
	}

	

	@Override
	public Cart updateCartById(int cartId, Cart cart) throws ShoppingCartException
	{
		Optional<Cart> cartTemp = cr.findById(cartId);
		if (cartTemp.isPresent() == false) 
		{
			throw new ShoppingCartException("Cart does not exist");
		} 
		else 
		{
			Cart updcart = cr.save(cart);
			return updcart;
		}
		
	}

	@Override
	public String deleteCart(Cart cart) throws ShoppingCartException 
	{
		List<Cart> cartTemp = cr.findAll();
		if (cartTemp.isEmpty()) 
		{
			throw new ShoppingCartException("Cart not found");
		} 
		else 
		{
			cr.deleteAll();
			return "All carts deleted";
		}
	}

	@Override
	public String deleteCartById(int cartId) throws ShoppingCartException
	{
		List<Cart> cartTemp = cr.findAll();
		if (cartTemp.isEmpty()) 
		{
			throw new ShoppingCartException("Cart not found");
		} 
		else 
		{
			cr.deleteById(cartId);;
			return "Cart deleted Successfuly";
		}
	}

}
