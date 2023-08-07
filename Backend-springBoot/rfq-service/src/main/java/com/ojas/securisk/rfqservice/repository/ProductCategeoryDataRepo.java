package com.ojas.securisk.rfqservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.securisk.rfqservice.entity.ProductCategeoryData;

@Repository
public interface ProductCategeoryDataRepo extends MongoRepository<ProductCategeoryData, String> {

	@Query("{'productCategeory': ?0}")
	ProductCategeoryData findNameByProductType(String productCategeory);
}
