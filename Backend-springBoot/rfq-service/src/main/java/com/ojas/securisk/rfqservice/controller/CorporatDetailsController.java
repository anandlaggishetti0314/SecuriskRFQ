package com.ojas.securisk.rfqservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ojas.securisk.rfqservice.entity.CorporateDetails;
import com.ojas.securisk.rfqservice.entity.CorporateDetailsInput;
import com.ojas.securisk.rfqservice.serviceImpl.CorporatDetailsServiceImpl;

@Controller
public class CorporatDetailsController {

	@Autowired
	private CorporatDetailsServiceImpl serviceImpl;

	@MutationMapping("saveCorporateDetails")
	public CorporateDetails saveCorporateDetails(@Argument CorporateDetailsInput corporateDetailsInput) {

		CorporateDetails corporateDetailsSave = serviceImpl.corporateDetailsSave(corporateDetailsInput);
		return corporateDetailsSave;
	}

	@QueryMapping("getAllCorporateDetails")
	public List<CorporateDetails> getAllCorporateDetails() {

		List<CorporateDetails> allCorporateDetails = serviceImpl.getAllCorporateDetails();
		return allCorporateDetails;
	}

	@QueryMapping("getACorporateDetailsById")
	public CorporateDetails getACorporateDetailsById(@Argument String _id) {
		CorporateDetails corporateDetailsById = serviceImpl.getCorporateDetailsById(_id);
		return corporateDetailsById;
	}

	@MutationMapping("deletACorporateDetailsById")
	public String deletACorporateDetailsById(@Argument String _id) {
		String detailsById = serviceImpl.deleteCorporateDetailsById(_id);
		return detailsById;

	}

	@MutationMapping("updateCorporateDetails")
	public CorporateDetails updateCorporateDetails(@Argument CorporateDetailsInput corporateDetails) {
		CorporateDetails updateCorporateDetails = serviceImpl.updateCorporateDetails(corporateDetails);

		return updateCorporateDetails;
	}

}
