package com.service;

import java.util.List;

import com.entity.Cart;
import com.exception.ShoppingCartException;

public interface ShoppingCartService {
	
	List<Cart> getAllCarts() throws ShoppingCartException;
	Cart getCartById(int cartId) throws ShoppingCartException;
	//Cart updateCart(Cart cart);
	Cart updateCartById(int cartId, Cart cart) throws ShoppingCartException;
	String deleteCart(Cart cart) throws ShoppingCartException;
	String deleteCartById(int cartId) throws ShoppingCartException;

}
