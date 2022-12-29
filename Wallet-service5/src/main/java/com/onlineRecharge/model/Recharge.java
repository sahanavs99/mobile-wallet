package com.onlineRecharge.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Recharge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recharge_id;

	@NotNull
    @Size(min=10,max=10, message="contact no min and max value 10 digits")
    private String mobile_number;
	
	//@NotBlank(message="amount is mandtory")
    private Double rechargeAmount;
	
    private Double initialBalance;
	
	
	
}
