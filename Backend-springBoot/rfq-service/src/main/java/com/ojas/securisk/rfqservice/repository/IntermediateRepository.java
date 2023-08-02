package com.ojas.securisk.rfqservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.securisk.rfqservice.entity.IntermediateDetails;

@Repository
public interface IntermediateRepository extends MongoRepository<IntermediateDetails, String> {

	@Query("{'productCategeory': ?0}")
	List<String> findNameByProductType(String productCategeory);

}
