package com.ojas.securisk.rfqservice.serviceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.securisk.rfqservice.Entity.IntermediateDetails;
import com.ojas.securisk.rfqservice.repository.IntermediateRepository;
import com.ojas.securisk.rfqservice.service.IntermediateService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class IntermediateServiceImpl implements IntermediateService {

	@Autowired
	private IntermediateRepository repository;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String insert(IntermediateDetails details) {
		Date date = new Date();

		details.setCurrentDate(date);
		details.setUpdatedDate(null);

		IntermediateDetails save = repository.save(details);
		if (save != null) {
			return "Data Inserted";
		} else {
			return "Data Not inserted";
		}
	}

	@Override
	public List<IntermediateDetails> getAllDetails() {
		List<IntermediateDetails> allDetails = repository.findAll();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		objectMapper.setDateFormat(dateFormat);

		return allDetails;
	}

	@Override
	public String update(IntermediateDetails details) {
	    Optional<IntermediateDetails> optionalDetail = repository.findById(details.getId());
	    if (optionalDetail.isPresent()) {
	        IntermediateDetails existingDetails = optionalDetail.get();

	        // Preserve the createdDate (currentDate) value from the existing object
	        Date createdDate = existingDetails.getCurrentDate();
	        details.setCurrentDate(createdDate);

	        // Set the updatedDate to the current date and time
	        Date updatedDate = new Date();
	        details.setUpdatedDate(updatedDate);

	        // Update the existing object with the new details
	        BeanUtils.copyProperties(details, existingDetails);

	        IntermediateDetails savedDetails = repository.save(existingDetails);

	        if (savedDetails != null) {
	            return "Data Updated";
	        } else {
	            return "Data Not Updated";
	        }
	    } else {
	        return "Data Not Found";
	    }
	}

}
