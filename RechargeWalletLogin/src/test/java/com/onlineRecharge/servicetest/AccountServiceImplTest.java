package com.onlineRecharge.servicetest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineRecharge.model.Account;
import com.onlineRecharge.repository.AccountRepository;
import com.onlineRecharge.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

	@Mock
	private AccountRepository accountRepository;
	
	@InjectMocks
	private AccountServiceImpl accountServiceImpl;
	
	@Test
	public void testSayHello() {
		assertEquals("say hello student controller",accountServiceImpl.sayHello());

	}
	@Test
	public void createAccount() {
		
		Account accObj = new Account(1,"88840761222","sana","psotpaid","Dvg@4321","sahanavs99@gmail.com",233.44);
		when(accountRepository.save(accObj)).thenReturn(accObj);
		assertEquals(accObj, accountServiceImpl.createAccount(accObj));
	}
	
	@Test
	public void getAccountService() {
	List<Account> listOfAccount=Arrays.asList(new Account(1,"88840761222","sana","psotpaid","Dvg@4321","sahanavs99@gmail.com",233.44),
			new Account(1,"88840761222","sana","psotpaid","Dvg@4321","sahanavs99@gmail.com",233.44));
	Mockito.when(accountRepository.findAll()).thenReturn(listOfAccount);
	List<Account> acclist=accountServiceImpl.getAccountService();
	assertEquals(2, acclist.size());
}

	

   @Test 
   public void findById() { 
	   Account accObj = new Account(1,"88840761222","sana","psotpaid","Dvg@4321","sahanavs99@gmail.com",233.44);
      Mockito.when(accountRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(accObj));
       Account acc =accountServiceImpl.findById(1);
      assertEquals(accObj, acc);
  }
   
   @Test
   public void updateAccount()
   {
	   Account accObj = new Account(1,"88840761222","sana","psotpaid","Dvg@4321","sahanavs99@gmail.com",233.44);
	   Mockito.when(accountRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(accObj));
	   when(accountRepository.saveAndFlush(any(Account.class))).thenReturn(accObj);
	  Account response =accountServiceImpl.updateAccount(accObj, 1);
	    assertNotNull(response);
	   
   }
   
   @Test
   public void deleteAccountById()
   {
	   Account accObj1 = new Account(2,"88840761222","sana","psotpaid","Dvg@4321","sahanavs99@gmail.com",233.44);
	   Mockito.when(accountRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(accObj1));
	   accountServiceImpl.deleteAccountById(2);
	   assertTrue(true);
	  
   }
}

