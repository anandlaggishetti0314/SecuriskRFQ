package com.ojas.securisk.rfqservice.service;

import java.util.List;

import com.ojas.securisk.rfqservice.Entity.IntermediateDetails;

public interface IntermediateService {

	public String insert(IntermediateDetails details);

	public List<IntermediateDetails> getAllDetails();

	String update(IntermediateDetails updatedDetails);
}
