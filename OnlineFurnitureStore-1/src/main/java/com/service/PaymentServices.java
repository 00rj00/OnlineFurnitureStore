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
	FurnitureOrder order;
	
	@Autowired
	BillRepository br;
	
	@Autowired
	OrderRepository or;
	
	@Autowired
	CustomerRepository cr;

	@Override
	public Bill getBillById(long billNo) 
	{
		return br.findById(billNo).orElse(null);
	}
	
	

	@Override
	public double payByCash(double amount,double price) throws Exception {
		
		double change = price - amount;
		return change;
		
		
	}



	@Override
	public Bill addBillDetails(Bill bill) {
		return br.save(bill);
	}

	
	

}
