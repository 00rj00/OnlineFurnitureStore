package com.repository;
import com.entity.*; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

	@Query(" from Furniture f where f.furnitureName = :furnitureName")
	Furniture findbyName(String furnitureName);
}
