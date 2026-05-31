package com.turing.javaee8.jpamvc.service;

import org.springframework.stereotype.Service;

@Service
public interface BankTransferService {
	
public void transfer(Long fromAcc,Long toAcc,Integer amount)throws Exception;


}