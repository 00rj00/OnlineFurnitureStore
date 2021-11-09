package com.service;

import java.util.List;

import com.entity.Furniture;
import com.exception.FurnitureServiceException;

public interface FurnitureManagementService {
	List<Furniture> getAllFurnitures() throws FurnitureServiceException;
	Furniture getFurnitureById(long furnitureId) throws FurnitureServiceException;
	Furniture registerFurniture(Furniture furniture) throws FurnitureServiceException;
	Furniture updateFurniture(long furnitureId,Furniture furniture) throws FurnitureServiceException;
	//Furniture updateFurnitureById(long furnitureId) throws FurnitureServiceException;
	String deleteFurniture(Furniture furniture) throws FurnitureServiceException;
	Furniture deleteFurnitureById(long furnitureId) throws FurnitureServiceException;

}
