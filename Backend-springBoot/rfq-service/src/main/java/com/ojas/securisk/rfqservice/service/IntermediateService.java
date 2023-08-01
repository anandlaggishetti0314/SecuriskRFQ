package com.ojas.securisk.rfqservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ojas.securisk.rfqservice.entity.IntermediateDetails;


@Service
public interface IntermediateService {

	public String insert(IntermediateDetails details);

	public List<IntermediateDetails> getAllDetails();

	String update(IntermediateDetails updatedDetails);
}
