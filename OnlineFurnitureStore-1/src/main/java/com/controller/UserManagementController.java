package com.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;
import com.service.UserManagementServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/userManagement")
public class UserManagementController 
{
	@Autowired
	UserManagementServices userservice;
	
	@PostMapping(path = "/registerUser")
	public ResponseEntity<FurnitureUser> registerUser(@RequestBody FurnitureUser user) throws UserNotFoundException 
	{
		FurnitureUser u = userservice.registerNewUser(user);
		ResponseEntity<FurnitureUser> re =  new ResponseEntity<FurnitureUser>(u, HttpStatus.OK);
		return re;
	}
	

	@PostMapping(path = "/loginUser")
	public String loginUser(@RequestBody FurnitureUser user) throws UserNotFoundException {
		
		String s = userservice.loginUser(user);
		
		return s;
	}
	
	
	@DeleteMapping(path = "/deleteUserById/{uid}")
	public ResponseEntity<FurnitureUser> deleteUserById(@PathVariable int uid) throws UserNotFoundException 
	{
		FurnitureUser u = userservice.deleteUserById(uid);
		ResponseEntity<FurnitureUser> re = new ResponseEntity<FurnitureUser>(u, HttpStatus.OK);
		return re;
	}
	
	
	@DeleteMapping(path = "/deleteUser")
	public String deleteUser(@RequestBody FurnitureUser user) throws UserNotFoundException 
	{		
		String u = userservice.deleteUser(user);
		return "User Deleted Successfully" + u;
	}
	
	
	@PutMapping(path = "/updateUser")
	public ResponseEntity<FurnitureUser> updateUser(@RequestBody FurnitureUser user) throws UserNotFoundException 
	{		
		FurnitureUser u = userservice.updateUser(user);
		ResponseEntity<FurnitureUser> re = new ResponseEntity<FurnitureUser>(u, HttpStatus.OK);
		return re;
	}
}
