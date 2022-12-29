package com.onlineRecharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RechargeWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(RechargeWalletApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
	  return new RestTemplate();
	}
}
