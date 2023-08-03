package com.ojas.securisk.rfqservice.serviceImpl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;
import com.ojas.securisk.rfqservice.repository.CoverageRepository;
import com.ojas.securisk.rfqservice.service.CoverageService;

public class CoverageServiceImpl implements CoverageService {

	@Autowired
	private CoverageRepository repository;

	@Override
	public String createCoverageDetails(CoverageDetails details) {
		String foldername = "coverageDetails";
		File folder = new File("E:\\SecuriskRFQ" + foldername);
		repository.save(details);
		return details.getId();
	}

}
