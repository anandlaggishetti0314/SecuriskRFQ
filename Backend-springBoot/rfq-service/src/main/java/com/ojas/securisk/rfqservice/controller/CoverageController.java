package com.ojas.securisk.rfqservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;
import com.ojas.securisk.rfqservice.serviceImpl.CoverageServiceImpl;

@RestController
public class CoverageController {
	
	@Autowired
	private CoverageServiceImpl service;
	
	@MutationMapping()
	public ResponseEntity<String> CreateCoverageDetails(CoverageDetails details) {
		
		if(details!=null) {
			String createCoverageDetails = service.createCoverageDetails(details);
			return new ResponseEntity<>(createCoverageDetails,HttpStatus.CREATED);
		}
		return null;
	}
	

}
