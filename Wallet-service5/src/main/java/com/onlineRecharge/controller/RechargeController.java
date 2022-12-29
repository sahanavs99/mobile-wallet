package com.onlineRecharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineRecharge.exception.NoAccountFoundException;
import com.onlineRecharge.model.Account;
import com.onlineRecharge.model.Recharge;
import com.onlineRecharge.service.RechargeService;

@RestController
@CrossOrigin(origins = "*")
public class RechargeController {

	@Autowired
	private RechargeService rechargeServivce;
	
	@PostMapping("/addRecharge/{acc_id}")
	public Recharge createRecharge(@RequestBody Recharge recharge, @PathVariable Integer acc_id) throws NoAccountFoundException 
	{
		 Recharge  rechargeObj =rechargeServivce.addRecharge(recharge.getMobile_number(),recharge.getRechargeAmount(),acc_id);
		return rechargeObj;
	}
	
	
	@GetMapping("/getListOfRechargeDetails")
	public List<Recharge> getRechrageDetails()
	{
	
		List<Recharge>  rechObj= rechargeServivce.getRechrageDetails();
		return rechObj;
		
	}

	
	@GetMapping("/getAccountDetials/{acc_id}")
	public Account getAccountDetails(@PathVariable("acc_id") Integer acc_id)
	{
		return rechargeServivce.getAccountDetails(acc_id);
	}
	
	
	
	@GetMapping("/getRechargeById/{id}")
	public Recharge getRechargeDetailsById(@PathVariable("id") Integer recharge_id)
	{
		Recharge  rechObj= rechargeServivce.getRechargeDetailsById(recharge_id);
		return rechObj;
		
	}
}
