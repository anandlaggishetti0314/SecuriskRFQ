package com.ojas.securisk.rfqservice.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "IntermediateDetails")
public class IntermediateDetails {

	@Id
	private String id;
	private List<String> productName;
	private String productCategeory;
	private Integer coverage;

	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
	private Date currentDate;

	@LastModifiedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
	private Date updatedDate;
}
