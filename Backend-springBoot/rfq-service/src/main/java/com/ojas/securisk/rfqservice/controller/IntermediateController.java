package com.ojas.securisk.rfqservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.securisk.rfqservice.Entity.IntermediateDetails;
import com.ojas.securisk.rfqservice.serviceImpl.IntermediateServiceImpl;

@RestController
public class IntermediateController {

	@Autowired
	private IntermediateServiceImpl service;

	@PostMapping("insert")
	public ResponseEntity<String> createIntermediateDetails(@RequestBody IntermediateDetails details) {
		service.insert(details);
		return new ResponseEntity<>("Intermediate details saved successfully.", HttpStatus.CREATED);

	}

	@GetMapping("getAll")
	public ResponseEntity<List<IntermediateDetails>> getAllDetails() {
		List<IntermediateDetails> allDetails = service.getAllDetails();
		return ResponseEntity.ok(allDetails);
	}

	@PutMapping("update")
	public ResponseEntity<String> updateDetails(@RequestBody IntermediateDetails updatedDetails) {
		String result = service.update(updatedDetails);
		return ResponseEntity.ok(result);
	}
}
