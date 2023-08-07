package com.ojas.securisk.rfqservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;

@Service
public interface CoverageService {

	String createCoverageDetails(CoverageDetails details);

	List<CoverageDetails> getAllCreateCoverageDetails();

	String updateCoverageDetails(CoverageDetails details);

	String uploadFile(String fileType, MultipartFile file);

}
