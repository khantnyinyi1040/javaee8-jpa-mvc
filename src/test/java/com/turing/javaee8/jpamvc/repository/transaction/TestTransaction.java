package com.turing.javaee8.jpamvc.repository.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.javaee8.jpamvc.service.BankTransferService;
@SpringBootTest
public class TestTransaction {

	@Autowired
	BankTransferService moneyTransferService;
	
	@Test
	void transactionTest() {
		
		try {
			this.moneyTransferService.transfer(2L, 1L, 4000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
