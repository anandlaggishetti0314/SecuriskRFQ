package com.ojas.securisk.rfqservice.service;

import java.util.List;

import com.ojas.securisk.rfqservice.entity.CorporateDetails;
import com.ojas.securisk.rfqservice.entity.CorporateDetailsInput;

public interface CorporateDetailsService {

	public CorporateDetails corporateDetailsSave(CorporateDetailsInput corporateDetailsInput);

	public List<CorporateDetails> getAllCorporateDetails();

	public CorporateDetails getCorporateDetailsById(String _id);
	
	public CorporateDetails updateCorporateDetails(CorporateDetails corporateDetails);

	public String deleteCorporateDetailsById(String _id);

}
