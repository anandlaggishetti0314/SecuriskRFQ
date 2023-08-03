package com.ojas.securisk.rfqservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Document(collection = "corporateDetails")
@Data
@ToString
public class CorporateDetails {

	private String _id;
	private String insuredName;
	private String address;

	private String businessNature;

	private String contactName;
	private String emailId;

	private Long phoneNumber;

	private String intermediaryName;
	private String intermdiaryContactName;
	private String intermediaryemailId;

	private Long intermediaryphoneNumber;

}