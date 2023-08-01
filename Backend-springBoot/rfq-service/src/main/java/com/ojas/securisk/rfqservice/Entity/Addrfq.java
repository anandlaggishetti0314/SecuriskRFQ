package com.ojas.securisk.rfqservice.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Addrfq")
public class Addrfq {
	@Id
	private String id;
	private String productCategoery;
	private List<String> product;
	private String policyType;

}
