package com.service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.entity.*;
//import com.exception.*;
import com.repository.*;

@Transactional
@Service

public class PaymentServices implements PaymentService
{
		
	//Auto wiring the objects for using the JpaRepository methods
	@Autowired
	BillRepository billRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;

	//Returns the Bill by ID for each user
	@Override
	public Bill getBillById(long billNo) 
	{
		return billRepo.findById(billNo).orElse(null);
	}
	
	
	//This method is for Cash On Delivery for the furniture Order
	@Override
	public double payByCash(double amount,double price) throws Exception {
		
		double change = price - amount;
		return change;
		
		
	}


	//This method is for adding Bill details before payment
	@Override
	public Bill addBillDetails(Bill bill) {
		return billRepo.save(bill);
	}

	
	

}
