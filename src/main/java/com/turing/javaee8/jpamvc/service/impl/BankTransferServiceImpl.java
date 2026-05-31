package com.turing.javaee8.jpamvc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee8.jpamvc.model.BankAccount;
import com.turing.javaee8.jpamvc.repository.BankAccountRepository;
import com.turing.javaee8.jpamvc.service.BankTransferService;
import com.turing.javaee8.jpamvc.service.exception.FinancialException;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BankTransferServiceImpl implements BankTransferService{

	@Autowired
	BankAccountRepository bankAccountDao;
	
	@Transactional(rollbackOn = {FinancialException.class})
	@Override
	public void transfer(Long fromAcc, Long toAcc, Integer amount) throws  Exception{
		this.debit(fromAcc, amount);//-
		this.credit(toAcc, amount);//+
	}
	
	void debit(Long fromAccount,Integer amount) throws Exception,FinancialException
	{
		Optional<BankAccount> result = this.bankAccountDao.findById(fromAccount);
		if(result.isPresent())
		{
			BankAccount account = result.get();
			if(account.getBalance()>= amount)
			{
				account.setBalance( account.getBalance()-amount);
				this.bankAccountDao.save(account);
			}
			else
			{
				throw new FinancialException("Invalid debit amount");
			}
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			throw new FinancialException("Invalid account");
		}
	}
	void credit(Long toAccount,Integer amount) throws Exception,FinancialException
	{
		Optional<BankAccount> result = this.bankAccountDao.findById(toAccount);
		if(result.isPresent())
		{
			log.info("Account Name "+result.get().getAccountName());
			BankAccount account = result.get();
			
			if(amount >0)
			{
				account.setBalance( account.getBalance()+amount);
				this.bankAccountDao.save(account);
			}
			else
			{
				throw new FinancialException("Invalid credit amount");
			}
		}
		else
		{
			throw new FinancialException("Invalid account");
		}
	}
	
	
	
}
