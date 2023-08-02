package com.ojas.securisk.rfqservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ojas.securisk.rfqservice.entity.ProductCategeoryData;

@Service
public interface ProductCategeoryDataService {

	public String createCategeory(ProductCategeoryData categeorydata);

	public List<ProductCategeoryData> getAllcategeoryDetails();

	public String updateProductCategeoryData(ProductCategeoryData updatedcategeoryDetails);

	public String deleteProductCategeoryData(String id);

	public ProductCategeoryData getByIdProductCategeory(String id);

}
