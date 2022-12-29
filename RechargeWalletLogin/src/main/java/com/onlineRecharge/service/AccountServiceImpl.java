package com.onlineRecharge.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.onlineRecharge.exception.UserNotFoundException;
import com.onlineRecharge.model.Account;
import com.onlineRecharge.model.Recharge;
import com.onlineRecharge.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String sayHello() {
		return "say hello student controller";		
	}

	@Override
	public Account createAccount(Account account) {
		Account accountObj =accountRepository.save(account);
		return accountObj;
	}

	@Override
	public List<Account> getAccountService() {
	
		List<Account> accountDetails =accountRepository.findAll();
		return accountDetails;
	}


	@Override
	public Account updateAccount(Account account, Integer acc_id) {
		
		Account  accUpdate =accountRepository.findById(acc_id).get();
		accUpdate.setUserName(account.getUserName());
		accUpdate.setPassword(account.getPassword());
		accUpdate.setMobile_number(account.getMobile_number());
				accUpdate.setEmail(account.getEmail());
				accUpdate.setAccount_type(account.getAccount_type());
				accUpdate.setInitial_balance(account.getInitial_balance());
				accountRepository.save(accUpdate);
				return accUpdate;
	}

	@Override
	public Account findById(Integer acc_id) {
		Account accObj =accountRepository.findById(acc_id).orElseThrow((()-> new UserNotFoundException("User not found with id: "+acc_id)));
			
		return accObj;
	}

	@Override
	public void deleteAccountById(Integer acc_id) {
		accountRepository.deleteById(acc_id);
		
	}

	@Override
	public Account loginAccount(Account account) {
		Account accObj =accountRepository.findByEmail(account.getEmail());
		if(accObj.getPassword().equals(account.getPassword())){
		return accObj;
		}
		return null;
	}

	@Override
	public String getAccountUpdateById(Account account, Integer id) {
	
		 Account acc=findById(id);
		 System.out.println(acc.getInitial_balance());
		 
		 Recharge rec=getRechargeDetails(id);
		 System.out.println(rec.getInitialBalance());
		//Account acc=null;
		//if(accountRepository.findById(account.getAccount_id()).get();
		//Recharge recharge = getRechargeDetails(id);
		//System.out.println((recharge.getInitialBalance()));
		//if(recharge.getInitialBalance() <=account.getInitial_balance())
		//{
		//	Account accObj =new Account();
			//accountRepository.findById(id).get();
		//	accObj.setInitial_balance(recharge.getInitialBalance());
		//	acc =accountRepository.save(accObj);
		//}
		
		return "updated";
		
	}

	@Override
	public Recharge getRechargeDetails(int id) {
		
		Recharge rechge =restTemplate.getForObject("http://localhost:9093/getRechargeById/"+id, Recharge.class);
		return rechge;
	}

	
	
	
	
	/*
	 * @Override public Plan getPlanDetails(int planid) {
	 * 
	 * Plan p =restTemplate.getForObject(
	 * "http://localhost:9092/onlineRecharge/getPlanDetails/"+planid, Plan.class);
	 * return p; }
	 */
	}



	 


	
	

