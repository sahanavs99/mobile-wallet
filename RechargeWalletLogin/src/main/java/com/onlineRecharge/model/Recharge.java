package com.onlineRecharge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Entity
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
