package com.ojas.securisk.rfqservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.securisk.rfqservice.entity.ProductCategeory;
import com.ojas.securisk.rfqservice.repository.ProductCategeoryRepo;
import com.ojas.securisk.rfqservice.service.ProductCategeoryService;

@Service
public class ProductCategeoryServiceImpl implements ProductCategeoryService {

	@Autowired
	public ProductCategeoryRepo productCategeoryRepo;

	public ProductCategeory createProduct(ProductCategeory productCategeory) {

		return productCategeoryRepo.save(productCategeory);
	}

	public List<ProductCategeory> getAll() {

		return productCategeoryRepo.findAll();
	}

}
