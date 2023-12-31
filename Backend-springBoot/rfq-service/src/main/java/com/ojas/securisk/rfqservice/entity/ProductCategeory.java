package com.ojas.securisk.rfqservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Product_Categories")
public class ProductCategeory {
	@Id
	private String id;
	
	private String productCategeory;

}
