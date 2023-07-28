package com.ojas.securisk.rfqservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ojas.securisk.rfqservice.Entity.IntermediateDetails;

public interface IntermediateRepository extends MongoRepository<IntermediateDetails, String> {

}
