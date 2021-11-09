package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Furniture;
import com.exception.FurnitureServiceException;
import com.repository.FurnitureRepository;
import com.service.FurnitureManagementServices;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringBootTest
public class FurnitureServicesTests 
{
	@Autowired
	FurnitureManagementServices furnitureService;
	@MockBean
	FurnitureRepository repo;
	
	@Test
	void testAddFurniture() throws FurnitureServiceException {
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(4);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("Wingback Chair");
		furniture.setFurnitureName("Chair");
		furniture.setPrice(123);
		Mockito.when(repo.save(furniture)).thenReturn(furniture);
		assertThat(furnitureService.registerFurniture(furniture)).isEqualTo(furniture);
	}
	
	
		
	
	@Test
	void updateFurniture() throws FurnitureServiceException{
		Furniture furniture=new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		Optional<Furniture> f = Optional.of(furniture);
		
		Mockito.when(repo.findById((long) 34)).thenReturn(f);
		assertThat(furnitureService.getFurnitureById(34)).isEqualTo(furniture);
	}
	
	
	@Test
	void geAllFurniture() throws FurnitureServiceException{
		Furniture furniture=new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		Furniture furniture1=new Furniture();
		furniture1.setFurnitureId(4);
		furniture1.setFurnitureColor("Black");
		furniture1.setFurnitureModel("Standard Showcase Frame");
		furniture1.setFurnitureName("Show case");
		
		List<Furniture> l = new ArrayList<>();
		l.add(furniture);
		l.add(furniture1);
		
		Mockito.when(repo.findAll()).thenReturn(l);
		assertThat(furnitureService.getAllFurnitures()).isEqualTo(l);
	}
	

}
