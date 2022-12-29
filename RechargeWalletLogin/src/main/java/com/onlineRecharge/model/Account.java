package com.onlineRecharge.model;

import jakarta.annotation.Resource;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer account_id;
	
	@NotBlank(message="name is mandtory")
	private String userName;
	
	@NotBlank(message="password is mandtory")
	private String password;
	
	@NotNull
    @Size(min=10,max=10, message="contact no min and max value 10 digits")
	private String mobile_number;
	
	@Email(message="not in format of email")
	private String email;
	
	@NotBlank(message = "name is mandtory")
	private String account_type;
	
	@NotNull
	private Double initial_balance;

	
	
  
}
