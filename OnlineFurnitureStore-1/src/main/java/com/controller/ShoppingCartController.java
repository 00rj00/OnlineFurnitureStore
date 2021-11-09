package com.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.exception.ShoppingCartException;
import com.service.ShoppingCartServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/Cart")
public class ShoppingCartController 
{
	@Autowired
	ShoppingCartServices cs;
	
	
	@GetMapping(path = "/getAllCarts", produces = "application/json")
	public ResponseEntity<List<Cart>> getAllCarts() throws ShoppingCartException 
	{
		List<Cart> allCarts = cs.getAllCarts();
		ResponseEntity<List<Cart>> re =  new ResponseEntity<List<Cart>>(allCarts, HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path = "/getCartDetails/{cartId}", produces = "application/json")
	public ResponseEntity<Cart> getCartById(@PathVariable int cartId) throws ShoppingCartException
	{
		Cart cartById = cs.getCartById(cartId);
		ResponseEntity<Cart> re = new ResponseEntity<Cart>(cartById,HttpStatus.OK);
		return re;
	}

	
	@DeleteMapping(path = "/deleteCart")
	public String deleteCart(@RequestBody Cart cart) throws ShoppingCartException
	{
		cs.deleteCart(cart);
		return "Cart deleted successfully";
	}
	
	
	@DeleteMapping(path = "/deleteCartById/{cartId}", produces = "application/json")
	public String deleteCartById(@PathVariable int cartId) throws ShoppingCartException
	{
		cs.deleteCartById(cartId);
		return "Cart deleted by id successfully";
	}
	
	
	@PutMapping("/updateCartById/{cartId}")
	public ResponseEntity<Cart> updateCartById(@RequestBody Cart cart) throws ShoppingCartException
	{
		Cart resultCart = cs.updateCartById(cart.getCartId(), cart);
		ResponseEntity<Cart> re = new ResponseEntity<Cart>(resultCart, HttpStatus.OK);
		return re;
	}
}
