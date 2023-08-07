//package com.ojas.securisk.rfqservice.resolver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.ojas.securisk.rfqservice.serviceImpl.CoverageServiceImpl;
//
//@Component
//public class CoverageDetailsMutationResolver implements GraphQLMutationResolver {
//
//	@Autowired
//	private CoverageServiceImpl coverageDetailsService;
//
//	public CoverageDetailsMutationResolver(CoverageServiceImpl coverageDetailsService) {
//		this.coverageDetailsService = coverageDetailsService;
//	}
//
//	public String uploadFile(String fileType, MultipartFile file) {
//		return coverageDetailsService.uploadFile(fileType, file);
//	}
//}
