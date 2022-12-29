package com.onlineRecharge.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer account_id;
	
	private String userName;
	private String password;
	
	private String mobile_number;
	private String email;
	private String account_type;
	private double initial_balance;

	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="fk_rech_id")
	//private Recharge recharge;
  
}
