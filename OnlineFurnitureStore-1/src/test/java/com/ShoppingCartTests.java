package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Cart;
import com.exception.ShoppingCartException;
import com.service.ShoppingCartService;

@SpringBootTest
public class ShoppingCartTests 
{
	@Autowired
	ShoppingCartService service;
	
		
	@Test
	void testGetCartById1() throws ShoppingCartException
	{
		Cart cart = service.getCartById(1);
		assertEquals(1, cart.getOrderNum());
		
	}
	
	@Test
	void testGetCartById2()
	{
		try 
		{
			service.getCartById(1);
		}
		catch(ShoppingCartException e)
		{
			assertEquals("cartId does not exist", e.getMessage());	
		}
		
	}
	
	@Test
	void testGetAllCarts() throws ShoppingCartException 
	{
		List<Cart> list = new ArrayList<>();
		Cart cart1 = service.getCartById(1);
        Cart cart2 = service.getCartById(2);
        list.add(cart1);
        list.add(cart2);
        assertNotNull(list);
		
	}
	
	@Test
	void testDeleteCartById1()
	{
		try {
			service.deleteCartById(2);
		}
		catch (ShoppingCartException e)
		{
			assertEquals("Cart does not exist", e.getMessage());
		}
		
	}
	
	
	
}
