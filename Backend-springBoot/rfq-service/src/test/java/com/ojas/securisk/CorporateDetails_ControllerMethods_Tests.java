package com.ojas.securisk;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
//import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;

import org.springframework.graphql.test.tester.HttpGraphQlTester;

import com.ojas.securisk.rfqservice.RfqServiceApplication;
import com.ojas.securisk.rfqservice.entity.CorporateDetails;
import com.ojas.securisk.rfqservice.serviceImpl.CorporateDetailsServiceImpl;

@SpringBootTest(classes = RfqServiceApplication.class)
@AutoConfigureHttpGraphQlTester
@Import(CorporateDetailsServiceImpl.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@RunWith(PowerMockRunner.class)
public class CorporateDetails_ControllerMethods_Tests {

	@Autowired
	private HttpGraphQlTester client;

	@Test
	@Order(1)
	public void getAllCorporateDetailsTest() {
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
		this.client.document(doc).execute().path("getAllCorporateDetails").entityList(CorporateDetails.class)
				.hasSizeGreaterThan(1)
				.path("getAllCorporateDetails.[0].insuredName").entity(String.class).isEqualTo("Life Foundation");
	}

	@Test
	@Order(2)
	public void getACorporateDetailsByIdTest() {

		String doc = """
				query {
				getACorporateDetailsById(_id:"114"){
				    _id
				    insuredName
				    address
				    address
				    businessNature
				    contactName
				    emailId
				    intermediaryName
				    intermdiaryContactName
				    intermediaryphoneNumber
				    intermediaryemailId
				    phoneNumber
				}
				}
						""";

		this.client.document(doc).operationName("getACorporateDetailsById").execute()
				.path("getACorporateDetailsById._id").entity(String.class).isEqualTo("114")
				.path("getACorporateDetailsById.insuredName").entity(String.class).isEqualTo("Life Foundation")
				.path("getACorporateDetailsById.address").entity(String.class).isEqualTo("Hyderabad");
	}

	@Test
	@Order(3)
	public void saveCorporateDetailsTest() {

		String createQuery = """
								 mutation{
				  saveCorporateDetails(corporateDetailsInput:{
				_id:"119"
				    insuredName:"Naresh"
				    address:"Hyderabad"
				    businessNature:"Training"
				    contactName:"Leela"
				    emailId:"leela@gmail.com"
				    phoneNumber:"9550622224"
				    intermediaryName:"Vinay Foundation"
				    intermdiaryContactName:"Vinay"
				    intermediaryemailId:"vinay@gmail.com"
				    intermediaryphoneNumber:"9550622234"
				  }){
				    _id
				    insuredName
				    address
				  }
				}

								""";

		this.client.document(createQuery)
				// .variable("corporateDetailsInput", CorporateDetails.create("112", "Life ",
				// "Hyderabad",
				// "Isurance","Subbu","subbu@gmail.com",9555065553L,"Vinay","Konda","vinay@gmail.com"
				// , 9550355543L ))
				.operationName("saveCorporateDetails").execute().path("saveCorporateDetails._id").entity(String.class)
				.isEqualTo("119").path("saveCorporateDetails.insuredName").entity(String.class).isEqualTo("Ashok info")
				.path("saveCorporateDetails.address").entity(String.class).isEqualTo("Hyderabad");
	}

	@Test
	@Order(4)
	public void updateCorporateDetailsTest() {

		String updateQuery = """
								 mutation{
				  updateCorporateDetails(corporateDetails:{
				  _id:"116"
				    address:"Kadapa"
				  }){
				    _id
				    insuredName
				    address
				    businessNature
				    contactName
				    emailId
				    intermediaryName
				    intermdiaryContactName
				    intermediaryphoneNumber
				    intermediaryemailId
				    phoneNumber
				  }
				}
								""";

		this.client.document(updateQuery)
		// .variable("id", 2)
		// .variable("corporateDetails",
//						CorporateDetails.create("112", "Quantum Life", "Hyderabad", "Isurance", "Subbu",
//								"subbu@gmail.com", 9555065553L, "Vinay", "Konda", "vinay@gmail.com", 9550355543L))
				.operationName("updateCorporateDetails").execute().path("updateCorporateDetails._id")
				.entity(String.class).isEqualTo("116").path("updateCorporateDetails.insuredName").entity(String.class)
				.isEqualTo("Naresh").path("updateCorporateDetails.address").entity(String.class).isEqualTo("Kadapa")
				.path("updateCorporateDetails").entity(CorporateDetails.class).satisfies(System.out::println);
	}

	@Test
	public void deleteCorporateDetailsByIdTest() {

		String deleteQuery = """
								 mutation{
				  deleteCorporateDetailsById(_id:"115")
				}
								""";

		this.client.document(deleteQuery)
				// .variable("_id", "113")
				.operationName("deletACorporateDetailsById").execute().path("deleteCorporateDetailsById")
				.entity(String.class).satisfies(System.out::println);

		// .path("response").entity(String.class).satisfies(r -> {
//						Assertions.assertThat(r.getId()).isEqualTo(3);
//						Assertions.assertThat(r.getStatus()).isEqualTo(Status.SUCCESS);
	}

}
