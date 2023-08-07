package com.ojas.securisk.rfqservice.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Product_CategoriesData")
@Builder
public class ProductCategeoryData {
	@Id
	private String id;
	private String productCategeory;
	private List<String> productName;

}
