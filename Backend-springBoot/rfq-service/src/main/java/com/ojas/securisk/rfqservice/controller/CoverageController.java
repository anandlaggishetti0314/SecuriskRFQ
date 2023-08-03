package com.ojas.securisk.rfqservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;
import com.ojas.securisk.rfqservice.serviceImpl.CoverageServiceImpl;

@Controller
public class CoverageController {
	
	@Autowired
	private CoverageServiceImpl service;
	
	@MutationMapping()
	public String createCoverageDetails(@Argument CoverageDetails details) {
		
		if(details!=null) {
			String createCoverageDetails = service.createCoverageDetails(details);
			return createCoverageDetails;
		}
		return null;
	}
	

}
