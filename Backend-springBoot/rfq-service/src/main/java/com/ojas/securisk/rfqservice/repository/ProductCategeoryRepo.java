package com.ojas.securisk.rfqservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ojas.securisk.rfqservice.entity.ProductCategeory;

@Repository
public interface ProductCategeoryRepo extends MongoRepository<ProductCategeory, Integer> {

}
