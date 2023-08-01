package com.ojas.securisk.rfqservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ojas.securisk.rfqservice.entity.ProductCategeory;
import com.ojas.securisk.rfqservice.serviceImpl.ProductCategeoryServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class ProductCategeoryController {

	@Autowired
	public ProductCategeoryServiceImpl productService;

	@MutationMapping()
	public ProductCategeory createProduct(@Argument ProductCategeory productCategeory) {
		return productService.createProduct(productCategeory);

	}

	@QueryMapping()
	public List<ProductCategeory> getAll() {
		return productService.getAll();

	}
}
