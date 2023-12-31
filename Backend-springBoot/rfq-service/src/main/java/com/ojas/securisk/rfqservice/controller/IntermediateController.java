
package com.ojas.securisk.rfqservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.securisk.rfqservice.entity.IntermediateDetails;

import com.ojas.securisk.rfqservice.serviceImpl.IntermediateServiceImpl;

@RestController
public class IntermediateController {

	@Autowired
	private IntermediateServiceImpl service;

	@MutationMapping()
	public String createIntermediateDetails(@Argument IntermediateDetails details) {
		System.out.println(details);
		service.insert(details);
		return "Intermediate details saved successfully.";

	}

	@QueryMapping()
	public List<IntermediateDetails> getAllDetails() {
		List<IntermediateDetails> allDetails = service.getAllDetails();
		return allDetails;
	}

	@MutationMapping()
	public String updateDetails(@Argument IntermediateDetails updatedDetails) {
		String result = service.update(updatedDetails);
		return result;
	}

//	@QueryMapping()
//	public List<String> getNamesByProductType(@Argument ProductCategeoryinput categeoryinput) {
//
//		//System.out.println(categeoryinput);
//		return service.getNamesByProductType(categeoryinput);
//	}
//	public List<String> getNamesByProductType(@Argument ProductCategeoryinput categeoryinput) {
//		List<String> dataList = service.getNamesByProductType(categeoryinput);
//
//		return dataList.stream().map(data -> data(ProductCategeoryinput.getProductCategeory()).collect(Collectors.toList());
//	}

	@QueryMapping()
	public List<String> getNamesByProductType(@Argument String productCategeory) {
		return service.getNamesByProductType(productCategeory);
	}

}
