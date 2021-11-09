package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Furniture;
import com.exception.FurnitureServiceException;
import com.service.FurnitureManagementServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/displayFurniture")
public class FurnitureManagementController 
{
	@Autowired
	FurnitureManagementServices fms;
	
	@PostMapping(path = "/addfurniture")
	public ResponseEntity<Furniture> addFurniture(@RequestBody Furniture furniture)throws FurnitureServiceException 
	{
		Furniture resultFurniture = fms.registerFurniture(furniture);
		ResponseEntity<Furniture> re = new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
		return re;
	}
	
	
	@DeleteMapping(path = "/deleteFurniture/{furnitureId}")
	public Furniture deleteFurnitureByID(@PathVariable("furnitureId") long furnitureId) throws FurnitureServiceException 
	{
		return fms.deleteFurnitureById(furnitureId);
	}
	
	
	@DeleteMapping(path = "/deleteFurniture")
	public String deleteFurniture(@RequestBody Furniture furniture) throws FurnitureServiceException 
	{
		fms.deleteFurniture(furniture);
		return "Deleted Successfully";
	}
	
	
	@PutMapping("/updateFurniture/{furnitureId}")
	public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture furniture)throws FurnitureServiceException {
		
		Furniture resultFurniture = fms.updateFurniture(furniture.getFurnitureId(), furniture);
		ResponseEntity<Furniture> re = new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path = "/getAllFurnitureDetails")
	public ResponseEntity<List<Furniture>> getAllFurnitureDetails() throws FurnitureServiceException {
		
		List<Furniture> resultFurniture = fms.getAllFurnitures();
		ResponseEntity<List<Furniture>> re = new ResponseEntity<List<Furniture>>(resultFurniture, HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path = "/getFurnitureDetalis/{furnitureId}")
	public ResponseEntity<Furniture> getFurnitureDetails(@PathVariable("furnitureId") long furnitureId)throws FurnitureServiceException {
		
		Furniture resultFurniture = fms.getFurnitureById(furnitureId);
		ResponseEntity<Furniture> re = new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
		return re;
	}
}
