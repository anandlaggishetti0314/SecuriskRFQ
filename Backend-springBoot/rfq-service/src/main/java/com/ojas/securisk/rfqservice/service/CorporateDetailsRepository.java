package com.ojas.securisk.rfqservice.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ojas.securisk.rfqservice.entity.CorporateDetails;

@Repository
public interface CorporateDetailsRepository extends MongoRepository<CorporateDetails, String> {

}
