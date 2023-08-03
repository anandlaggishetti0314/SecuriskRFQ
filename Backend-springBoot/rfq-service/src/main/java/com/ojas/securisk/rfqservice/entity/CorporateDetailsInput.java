package com.ojas.securisk.rfqservice.entity;

import lombok.Data;

@Data
public class CorporateDetailsInput {

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
