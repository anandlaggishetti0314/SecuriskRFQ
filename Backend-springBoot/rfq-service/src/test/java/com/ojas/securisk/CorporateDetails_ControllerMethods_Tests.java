package com.ojas.securisk;

import org.springframework.boot.test.context.SpringBootTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.context.TestPropertySource;

import com.ojas.securisk.rfqservice.entity.CorporateDetails;

@SpringBootTest
@AutoConfigureHttpGraphQlTester
public class CorporateDetails_ControllerMethods_Tests {

	@Autowired
	private HttpGraphQlTester client;

	@Test
	public void getAllCorporateDetailsTest(){
		var doc = """
					query{  
     getAllCorporateDetails{
    _id
    insuredName
    address
    businessNature
    contactName
    emailId
    phoneNumber
    intermediaryName
    intermdiaryContactName
    intermediaryemailId
    intermediaryphoneNumber
  }
}
				""";
		this.client.document(doc)
				.execute()
				.path("getAllCorporateDetails").entityList(Object.class).hasSizeGreaterThan(2)
				.path("getAllCorporateDetails.[0].insuredName").entity(String.class).isEqualTo("subbu");
	}

	@Test
	public void getACorporateDetailsByIdTest(){
		this.client.documentName("corporate-details")
				.variable("_id", "111")
				.operationName("getACorporateDetailsById")
				.execute()
				.path("response._id").entity(String.class).isEqualTo("111")
			    .path("response.insuredName").entity(String.class).isEqualTo("subbu")
			    .path("response.address").entity(String.class).isEqualTo("Hyderabad");
	}

	@Test
	public void saveCorporateDetailsTest(){
	
		this.client.documentName("corporate-details")
				   .variable("corporateDetailsInput", CorporateDetails.create("112", "Life ", "Hyderabad", "Isurance","Subbu","subbu@gmail.com",9555065553L,"Vinay","Konda","vinay@gmail.com"  , 9550355543L ))
				   .operationName("saveCorporateDetails")
				   .execute()
				   .path("response._id").entity(String.class).isEqualTo("112")
				    .path("response.insuredName").entity(String.class).isEqualTo("subbu")
				    .path("response.address").entity(String.class).isEqualTo("Hyderabad");
	}

	@Test
	public void updateCorporateDetailsTest(){
		this.client.documentName("corporate-details")
				   .variable("id", 2)
				   .variable("corporateDetails", CorporateDetails.create("112", "Quantum Life", "Hyderabad", "Isurance","Subbu","subbu@gmail.com",9555065553L,"Vinay","Konda","vinay@gmail.com"  , 9550355543L ))
				   .operationName("UpdateCustomer")
				   .execute()
				   .path("response._id").entity(String.class).isEqualTo("112")
				   .path("response.insuredName").entity(String.class).isEqualTo("subbu")
				   .path("response.address").entity(String.class).isEqualTo("Hyderabad")
				   .path("response").entity(Object.class).satisfies(System.out::println);
	}

	@Test
	public void deletACorporateDetailsByIdTest(){
		this.client.documentName("corporate-details")
				   .variable("_id", "111")
				   .operationName("deletACorporateDetailsById")
				   .execute()
				   .path("response").entity(Object.class).satisfies(System.out::println);
//				   .path("response").entity(String.class).satisfies(r -> {
//						Assertions.assertThat(r.getId()).isEqualTo(3);
//						Assertions.assertThat(r.getStatus()).isEqualTo(Status.SUCCESS);
	}


}
