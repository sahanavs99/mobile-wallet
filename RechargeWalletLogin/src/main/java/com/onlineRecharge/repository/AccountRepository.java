package com.onlineRecharge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import com.onlineRecharge.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	
	Account findByEmail(String email);


	
	
	Optional<Account> findById(Integer acc_id) ;
		
	}

