package com.onlineRecharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineRecharge.model.Account;
import com.onlineRecharge.model.Recharge;
import com.onlineRecharge.service.AccountService;


@RestController
@RequestMapping("/onlineRecarge")
@CrossOrigin(origins = "http://localhost:4200/")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/addAccount")
	public Account createAccount(@RequestBody Account account) 
    {
		System.out.println(account);
		Account accountObj=accountService.createAccount(account);
		return accountObj;
		
}
	
	@GetMapping("/getAccountDetails")
	public List<Account> getAccountDetails()
	{
		List<Account> listOfAccount =accountService.getAccountService();
		return listOfAccount;
		
	}
	
	  @PutMapping("/account/{id}")
	    public Account updateAccount(@RequestBody Account account,
	                     @PathVariable("id") Integer acc_Id)
	    {
	        return accountService.updateAccount(account, acc_Id);
	        	
	    }
	  
	  @DeleteMapping("/delete/Account/{id}")
	    public String deleteAccountById(@PathVariable("id") Integer acc_Id)
	    {
		  accountService.deleteAccountById(acc_Id);
	        return "Deleted Successfully";
	    }
	
		@GetMapping("/getAccountDetails/{id}")
		public Account GetAccountById(@PathVariable("id") Integer acc_id) 
		{
			Account accountObject =accountService.findById(acc_id);
			return accountObject; 
  }
		
		@PostMapping("/login")
		public Account loginUser(@RequestBody Account account) throws Exception 
		{
			System.out.println(account);
		
			Account accountObject=accountService.loginAccount(account);
			if(accountObject!=null) {
				
			return accountObject;
			}
			if(accountObject==null)
			{
				throw new Exception("bad craediatls");
				//System.out.println("bad creaditals");
			}
			return accountObject;
		}
		
		
		
		
		@PutMapping("/updateAccount/{id}")
		public String getAccountUpdateInitialBalnce(@RequestBody Account account,@PathVariable Integer id)
		{
			accountService.getAccountUpdateById(account,id);
			return "sucess";
		}
		
		
		@GetMapping("/getRechargeDetialsById/{id}")
		public Recharge getRechargeDetails(@PathVariable("id") int id) {
			return accountService.getRechargeDetails(id);
		}
		
	}
 

