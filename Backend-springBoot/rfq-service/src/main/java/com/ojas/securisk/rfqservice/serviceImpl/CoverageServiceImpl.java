package com.ojas.securisk.rfqservice.serviceImpl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;
import com.ojas.securisk.rfqservice.repository.CoverageRepository;
import com.ojas.securisk.rfqservice.service.CoverageService;

@Service
public class CoverageServiceImpl implements CoverageService {

	@Autowired
	private CoverageRepository repository;

	@Override
	public String createCoverageDetails(CoverageDetails details) {
		repository.save(details);
		return details.getId();
	}

	@Override
	public List<CoverageDetails> getAllCreateCoverageDetails() {
		List<CoverageDetails> coverageDetails = repository.findAll();
		return coverageDetails;
	}

	@Override
	public CoverageDetails updateCoverageDetails(String id, CoverageDetails details) {
		return repository.save(details);
		
		//		Optional<CoverageDetails> findById = repository.findById(id);
//		CoverageDetails coverageDetails=null;
//		if (findById.isPresent()) {
//			coverageDetails=repository.save(details);
//		}
//		return coverageDetails;
	}

	@Override
	public Optional<CoverageDetails> getCoverageDetailById(String id) {
		Optional<CoverageDetails> findById = repository.findById(id);
		return findById;

	}

}
