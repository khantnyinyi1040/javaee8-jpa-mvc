package com.turing.javaee8.jpamvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee8.jpamvc.service.BankTransferService;

@RestController
@RequestMapping("/api")
public class BankTransferController {

	
	@Autowired
	BankTransferService bankTransferService;
	@PostMapping("/transfer/{from}/{to}/{amount}")
	String transfer(@PathVariable("from") Long fromAccount, @PathVariable("to") Long toAccount, @PathVariable("amount") Integer amount) throws Exception {
		this.bankTransferService.transfer(fromAccount, toAccount, amount);
		return "Transfered successfully "+amount+" From " + fromAccount+ " To "+toAccount;
		
	}
}
