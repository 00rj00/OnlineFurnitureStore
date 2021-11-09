package com.service;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.*;
import com.exception.*;
import com.repository.*;

@Service
public class FurnitureManagementServices implements FurnitureManagementService
{
	@Autowired
	private FurnitureRepository furnitureRepo;

	
	@Override
	public List<Furniture> getAllFurnitures() throws FurnitureServiceException{
		List<Furniture> getFurniture;
		try 
		{
			getFurniture = furnitureRepo.findAll();
			if(!getFurniture.isEmpty())
			{
				return getFurniture;
			}
			else
			{
				throw new FurnitureServiceException("The table is empty");
			}
			
		}
		catch(Exception e)
		{
			throw new FurnitureServiceException("The table is empty");
		}
		
	}

	
	@Override
	public Furniture getFurnitureById(long furnitureId) throws FurnitureServiceException
	{
		Furniture getFurniture = null;
		try 
		{
			getFurniture =furnitureRepo.findById(furnitureId).orElse(null);
			if(getFurniture!=null)
			{
				if (getFurniture.getFurnitureId() == furnitureId)
				{
					getFurniture = furnitureRepo.findById(furnitureId).orElse(null);
				}
				else
				{
					throw new FurnitureServiceException("Id is not Present");
				}
			}
			else
			{
				throw new FurnitureServiceException("Id is not Present");
			}
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		return getFurniture;
	}

	
	@Override
	public Furniture registerFurniture(Furniture furniture) throws FurnitureServiceException{
		Furniture addFurniture = furnitureRepo.save(furniture);
		return addFurniture;
	}

	
	
	@Override
	public Furniture updateFurniture(long furnitureId,Furniture furniture) throws FurnitureServiceException{
		Furniture updFurniture;
		try {
				updFurniture = furnitureRepo.save(furniture);
				return updFurniture;
		} 
		catch (Exception e) 
		{
			throw new FurnitureServiceException("id not found");
		}
	}

	

	
	@Override
	public String deleteFurniture(Furniture furniture) throws FurnitureServiceException{
		List<Furniture> resultFurniture;
		try 
		{
			resultFurniture = furnitureRepo.findAll();
			if (resultFurniture != null) 
			{
				furnitureRepo.deleteAll();
				return "All Values are deleted successfully";
			} 
			else 
			{
				throw new FurnitureServiceException("There is no value in the furniture");
			}
		} 
		catch (Exception e) 
		{
			throw new FurnitureServiceException("There is no value in the furniture");
		}
	}

	
	@Override
	public Furniture deleteFurnitureById(long furnitureId) throws FurnitureServiceException{
		Furniture furniture = new Furniture();
		try 
		{
			furniture = furnitureRepo.findById(furnitureId).orElse(null);
			if (furniture.getFurnitureId() != 0) 
			{
				furnitureRepo.deleteById(furnitureId);
				
			} 
			else 
			{
				throw new FurnitureServiceException("Id is not Found");
			}
		} 
		catch (Exception e) 
		{
			throw new FurnitureServiceException("id is not found");
		}
		return furniture;

	}

	
}
