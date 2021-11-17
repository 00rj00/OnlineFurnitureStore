package com;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;
import com.service.UserManagementService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserManagementTests 
{
	@Autowired
	UserManagementService service;
	
	private static int uId;
	private static String username;
	private static String password;
	
	@Test
	@Order(1)
	void testregisterNewUser() {
		
		
		FurnitureUser user=new FurnitureUser(1, "password", "admin", "username");
		try
		{
			FurnitureUser dto = service.registerNewUser(user);
		user.setUId(dto.getUId());
		boolean equals=false;
		equals = dto.getPassword().equals(user.getPassword()) && dto.getRole().equals(user.getRole()) && dto.getUsername().equals(dto.getUsername());
		uId=dto.getUId();
		assertTrue(equals);}
		
		catch(UserNotFoundException e)
		{
			fail("User is not added");
		}
	}

	@Test
	@Order(2)
	void testAddUserAgain() {
		
		
		FurnitureUser user=new FurnitureUser(1, "password", "admin", "username");
		assertThrows(UserNotFoundException.class,()->service.registerNewUser(user));
		
	}
	
	@Order(3)
	@Test
	void testUpdateUser() throws UserNotFoundException {
		
		FurnitureUser user=new FurnitureUser(uId, "pwdnew", "admin", "username");
		FurnitureUser dto = service.updateUser(user);
		assertNotNull(dto);
		
	}

	@Order(4)
	@Test
	void testUpdateUserInvalidID() {
		
		FurnitureUser user=new FurnitureUser(150, "pwdnew", "admin", "username");
		assertThrows(UserNotFoundException.class, ()-> service.updateUser(user));
		
	}
	

	

	/*
	 * Test method for {@link com.cg.cars.service.UserServiceImpl #DeleteUser()}.
	 */
	@Order(5)
	@Test
	void testDeleteUserById() {
		
		try {
			assertNotNull(service.deleteUserById(uId));
			
		} catch (UserNotFoundException e) {
			fail("User cannot be deleted due to " + e.getMessage());
		}
	}
	
	

	@Order(6)
	@Test
	void testDeleteUserInvalidID() {
		
		assertThrows(UserNotFoundException.class, ()->service.deleteUserById(1000));
		
	}
	

}
