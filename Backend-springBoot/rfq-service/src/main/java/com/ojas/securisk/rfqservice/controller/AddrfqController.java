//package com.ojas.securisk.rfqservice.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ojas.securisk.rfqservice.entity.Addrfq;
//import com.ojas.securisk.rfqservice.servceImpl.AddrfqServiceImpl;
//
//@RestController
//public class AddrfqController {
//	
//	@Autowired
//	public AddrfqServiceImpl addrfqservice;
//	
//	@MutationMapping()
//	public List<String> create(Addrfq rfq) {
//		return addrfqservice.create(rfq);		
//	}
//
//@QueryMapping()
//	public List<Addrfq> getAll() {
//		return addrfqservice.getAll();
//		
//	}
//	
//	
//
//}
