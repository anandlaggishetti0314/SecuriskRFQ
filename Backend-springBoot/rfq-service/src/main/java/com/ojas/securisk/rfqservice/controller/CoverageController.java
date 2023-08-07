package com.ojas.securisk.rfqservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;
import com.ojas.securisk.rfqservice.serviceImpl.CoverageServiceImpl;

@RestController
public class CoverageController {

	@Autowired
	private CoverageServiceImpl service;

	@MutationMapping()
	public String createCoverageDetails(@Argument CoverageDetails details) {

		if (details != null) {
			String createCoverageDetails = service.createCoverageDetails(details);
			return createCoverageDetails;
		}
		return null;
	}

	@QueryMapping()
	public List<CoverageDetails> getAllCreateCoverageDetails() {
		return service.getAllCreateCoverageDetails();
	}

	@MutationMapping("updateCoverageDetails")
	public String updateCoverageDetails(@Argument("updateCoveragedetails") CoverageDetails updateCoveragedetails) {
		return service.updateCoverageDetails(updateCoveragedetails);
	}

	@MutationMapping()
	public String uploadFile(@Argument MultipartFile file) {

		return service.uploadFile(null, file);

	}

}
