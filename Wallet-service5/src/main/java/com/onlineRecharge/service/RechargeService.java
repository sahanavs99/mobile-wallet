package com.onlineRecharge.service;

import java.util.List;

import com.onlineRecharge.exception.NoAccountFoundException;
import com.onlineRecharge.model.Account;
import com.onlineRecharge.model.Recharge;


public interface RechargeService {
	
	

	Account getAccountDetails(Integer acc_id);


	Recharge addRecharge(String mobNo,Double rechargeAmt,Integer acc_id) throws NoAccountFoundException ;

	List<Recharge> getRechrageDetails();


	Recharge getRechargeDetailsById(Integer recharge_id);

}
