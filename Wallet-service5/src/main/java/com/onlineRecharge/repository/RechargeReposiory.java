package com.onlineRecharge.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineRecharge.model.Account;
import com.onlineRecharge.model.Recharge;

@Repository
public interface RechargeReposiory extends JpaRepository<Recharge, Integer>{

	
}
