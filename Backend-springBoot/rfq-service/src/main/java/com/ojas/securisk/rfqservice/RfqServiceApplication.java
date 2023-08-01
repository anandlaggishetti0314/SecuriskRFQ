package com.ojas.securisk.rfqservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RfqServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RfqServiceApplication.class, args);
	}

}
