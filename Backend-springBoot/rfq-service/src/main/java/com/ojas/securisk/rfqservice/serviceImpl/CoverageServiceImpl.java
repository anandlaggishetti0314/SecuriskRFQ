package com.ojas.securisk.rfqservice.serviceImpl;

import java.io.File;
import java.util.List;

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
		String foldername = "coverageDetails";
		File folder = new File("E:\\SecuriskRFQ" + foldername);
		repository.save(details);
		return details.getId();
	}

	@Override
	public List<CoverageDetails> getAllCreateCoverageDetails() {
		List<CoverageDetails> coverageDetails = repository.findAll();
		return coverageDetails;
	}

	@Override
	public String updateCoverageDetails(CoverageDetails details) {
		repository.save(details);
		return "Updated Succuessfully";
	}

	@Override
	public String uploadFile(String fileType, MultipartFile file) {
		try {
			Workbook workbook = WorkbookFactory.create(file.getInputStream());

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "File uploaded successfully!";
	}
}
