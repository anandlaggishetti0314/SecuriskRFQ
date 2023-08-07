package com.ojas.securisk.rfqservice.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.securisk.rfqservice.entity.ProductCategeoryData;
import com.ojas.securisk.rfqservice.repository.ProductCategeoryDataRepo;

import com.ojas.securisk.rfqservice.service.ProductCategeoryDataService;

@Service
public class ProductCategeoryDataServiceImpl implements ProductCategeoryDataService {

	@Autowired
	private ProductCategeoryDataRepo productCategeoryDataRepo;

	@Override
	public String createCategeory(ProductCategeoryData categeorydata) {
		ProductCategeoryData categeory = productCategeoryDataRepo.insert(categeorydata);
		if (categeory != null) {
			return "Categeory Data Inserted";
		} else {
			return "Categeory Data Not inserted";
		}
	}

	@Override
	public List<ProductCategeoryData> getAllcategeoryDetails() {
		List<ProductCategeoryData> allcategeoryDetails = productCategeoryDataRepo.findAll();
		return allcategeoryDetails;
	}

	@Override
	public String updateProductCategeoryData(ProductCategeoryData updatedcategeoryDetails) {
		productCategeoryDataRepo.save(updatedcategeoryDetails);
		return "data updated";
	}

	@Override
	public String deleteProductCategeoryData(String id) {
		ProductCategeoryData categeoryData = getByIdProductCategeory(id);
		productCategeoryDataRepo.deleteById(id);
		return "deleted categeoryData";
	}

	@Override
	public ProductCategeoryData getByIdProductCategeory(String productCategeory) {
		ProductCategeoryData categeorydeleteData = productCategeoryDataRepo.findNameByProductType(productCategeory);
		return categeorydeleteData;
	}

}
