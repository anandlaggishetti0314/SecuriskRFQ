package com.ojas.securisk.rfqservice.controller;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;
import com.ojas.securisk.rfqservice.exception.CoverageNotFoundException;
import com.ojas.securisk.rfqservice.exception.CoveragesNotFoundException;
import com.ojas.securisk.rfqservice.serviceImpl.CoverageServiceImpl;

import graphql.GraphQLException;
import lombok.Data;

@RestController
public class CoverageController {

	@Autowired
	private CoverageServiceImpl service;

	@MutationMapping()
	public String createCoverageDetails(@Argument CoverageDetailsInput coverageInput) {
		if (coverageInput == null) {
			throw new GraphQLException("CoverageDetails object cannot be null.");
		} else {
			try {
				CoverageDetails coverageDetails = new CoverageDetails();
				BeanUtils.copyProperties(coverageInput, coverageDetails);
				String createCoverageDetails = service.createCoverageDetails(coverageDetails);
				return createCoverageDetails;
			} catch (Exception e) {
				throw new GraphQLException("Error creating CoverageDetails: " + e.getMessage());
			}
		}
	}

	@QueryMapping()
	public List<CoverageDetails> getAllCreateCoverageDetails() {
		List<CoverageDetails> allCreateCoverageDetails = service.getAllCreateCoverageDetails();
		if (allCreateCoverageDetails.isEmpty()) {
			throw new CoveragesNotFoundException(ErrorType.BAD_REQUEST, "Coverage details are not available",
					Map.of("coverageDetails", "Table is Empty Insert the data"));
		} else {
			return allCreateCoverageDetails;
		}
	}
	
	
	@QueryMapping("getCoverageDetailById")
	public CoverageDetails getCoverageDetailById(@Argument String id) {
		Optional<CoverageDetails> coverageDetailById = service.getCoverageDetailById(id);
		if(coverageDetailById.isEmpty()) {
			throw new CoverageNotFoundException(ErrorType.BAD_REQUEST,"Coverage not Found", Map.of("CoverageId",id));
		}
		return coverageDetailById.get();
		
	}

	@MutationMapping("updateCoverageDetails")
	public CoverageDetails updateCoverageDetails(@Argument String id,
			@Argument CoverageDetailsInput coverageInput) {
		Optional<CoverageDetails> coverageDetailById = service.getCoverageDetailById(id);
		
		if(coverageDetailById.isPresent()) {
			CoverageDetails existingCoverageDetails = coverageDetailById.get();
			
			Field[] fields = CoverageDetailsInput.class.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(coverageInput);
                    if (value != null) {
                        Field targetField = CoverageDetails.class.getDeclaredField(field.getName());
                        targetField.setAccessible(true);
                        targetField.set(existingCoverageDetails, value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            CoverageDetails updateCoverageDetails = service.updateCoverageDetails(id, existingCoverageDetails);
            return updateCoverageDetails;
			
		}
		return null;
	}

	

}

@Data
class CoverageDetailsInput {

	String id;
	String policyType;
	String familyDefination;
	String sumInsured;
	boolean familyDefination13;
	boolean familyDefination15;
	boolean familyDefinationParents;
	List<Double> familyDefination13SumInsured;
	List<Double> familyDefination15SumInsured;
	List<Double> familyDefinationParentSumInsured;
	boolean empData;
	String employeeDeptDataFilePath;
	String mandateLetterFilePath;
	String coverageSought;
	String DownloadTemplate;
	String filledTemplate;
	String employeeDeptDataFilePath1;
	String coverageSought1;
	String uploadFile;
}
