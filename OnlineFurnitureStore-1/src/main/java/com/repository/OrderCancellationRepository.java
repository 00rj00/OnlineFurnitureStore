package com.repository;
import com.entity.*; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderCancellationRepository extends JpaRepository<FurnitureOrder, String> {

}
