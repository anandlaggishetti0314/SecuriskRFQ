package com.ojas.securisk.rfqservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor(staticName = "create")
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
