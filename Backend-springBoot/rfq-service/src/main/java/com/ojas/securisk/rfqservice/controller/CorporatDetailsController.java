package com.ojas.securisk.rfqservice.controller;

import java.lang.reflect.Field;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ojas.securisk.rfqservice.entity.CorporateDetails;
import com.ojas.securisk.rfqservice.entity.CorporateDetailsInput;
import com.ojas.securisk.rfqservice.serviceImpl.CorporateDetailsServiceImpl;


@Controller
public class CorporatDetailsController {

	@Autowired
	private CorporateDetailsServiceImpl serviceImpl;

	@MutationMapping("saveCorporateDetails")
	public CorporateDetails saveCorporateDetails(@Argument CorporateDetails corporateDetails) {

		CorporateDetails corporateDetailsSave = serviceImpl.corporateDetailsSave(corporateDetails);
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

	@MutationMapping("deleteCorporateDetailsById")
	public String deleteCorporateDetailsById(@Argument("_id") String _id) {
		String detailsById = serviceImpl.deleteCorporateDetailsById(_id);
		return detailsById;

	}

	@MutationMapping("updateCorporateDetails")
	public CorporateDetails updateCorporateDetails(@Argument("corporateDetails") CorporateDetailsInput corporateDetailsInput) {
		
		CorporateDetails  updateCorporateDetails=  serviceImpl.getCorporateDetailsById(corporateDetailsInput.get_id());
		
		// updating only non-null fields in database using reflection api
		 Field[] fields = CorporateDetailsInput.class.getDeclaredFields();
		    for (Field field : fields) {
		        try {
		            field.setAccessible(true);
		            Object value = field.get(corporateDetailsInput);
		            if (value != null) {
		                Field targetField = CorporateDetails.class.getDeclaredField(field.getName());
		                targetField.setAccessible(true);
		                targetField.set(updateCorporateDetails, value);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
			    
		if(updateCorporateDetails != null) {
		    updateCorporateDetails = serviceImpl.updateCorporateDetails(updateCorporateDetails);
		}
		
		return updateCorporateDetails;
	}

}
