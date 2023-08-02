package com.ojas.securisk.rfqservice.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Coverage Details")
public class CoverageDetails {

	@Id
	private String id;

	@NotNull
	@Field("POLICY TYPE")
	private String policyType;
	@NotNull
	@Field("FAMILYDEFINATION")
	private String familyDefination;
	@NotNull
	@Field("SUMINSURED")
	private String sumInsured;
	@Field("FALIMYDEFINATION_13")
	private Boolean familyDefination13;
	@Field("FAMILYDEFINATION_15")
	private Boolean famityDefination15;
	@Field("FAMILYDEFINATIONPARENT")
	private Boolean familyDefinationParentsOnly;
	@Field("FAMILYDEFINATION_13_SUMINSURED")
	private List<Double> familyDefinatio13SumInsured;
	@Field("FAMILYDEFINATION_15_SUMINSURED")
	private List<Double> familyDefinatio15SumInsured;
	@Field("FAMILYDEFINATIONPARENTSUMINSURED")
	private List<Double> familyDefinationParentSumInsured;
	@Field("EMP_DATA")
	private boolean empData;
	@Field("EMPDATADEPTDATAFILEPATH")
	String employeeDeptDataFilePath;
	@Field("MANDATELETTERFILEPATH")
	String mandateLetterFilePath;
	@Field("COVERAGESOUGHT")
	String coverageSought;
	@Field("DOWNLOADTEMPLATE")
	String DownloadTemplate;
	@Field("FILLEDTEMPLATE")
	String filledTemplate;
	@Field("EMPDATADEPTDATAFILEPATH1")
	String employeeDeptDataFilePath1;
	@Field("COVERAGESOUGHT1")
	String coverageSought1;

}
