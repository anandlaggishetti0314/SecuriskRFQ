package com.ojas.securisk.rfqservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ojas.securisk.rfqservice.entity.CoverageDetails;

@Repository
public interface CoverageRepository extends MongoRepository<CoverageDetails, String> {

}
