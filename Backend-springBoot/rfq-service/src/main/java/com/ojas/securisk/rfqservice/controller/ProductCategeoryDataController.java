package com.ojas.securisk.rfqservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.securisk.rfqservice.entity.ProductCategeoryData;
import com.ojas.securisk.rfqservice.serviceImpl.ProductCategeoryDataServiceImpl;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductCategeoryDataController {
	@Autowired
	private ProductCategeoryDataServiceImpl productCategeoryService;

	@MutationMapping()
	public String createCategeory(@Argument ProductCategeoryData categeorydata) {
		return productCategeoryService.createCategeory(categeorydata);

	}

	@QueryMapping()
	public List<ProductCategeoryData> getAllcategeory() {
		return productCategeoryService.getAllcategeoryDetails();
	}

	@MutationMapping()
	public String updateProductCategeory(@Argument ProductCategeoryData updatedcategeoryDetails) {
		return productCategeoryService.updateProductCategeoryData(updatedcategeoryDetails);
	}

	@MutationMapping()
	public String deleteProductCategeory(@Argument String id) {
		return productCategeoryService.deleteProductCategeoryData(id);
	}

	@QueryMapping()
	public ProductCategeoryData findNameByProductType(@Argument String productCategeory) {
		return productCategeoryService.getByIdProductCategeory(productCategeory);
	}

}
