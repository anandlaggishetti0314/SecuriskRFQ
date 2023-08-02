package com.ojas.securisk.rfqservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ojas.securisk.rfqservice.entity.ProductCategeory;

@Service
public interface ProductCategeoryService {

	public ProductCategeory createProduct(ProductCategeory productCategeory);

	public List<ProductCategeory> getAll();

}
