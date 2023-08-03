package com.ojas.securisk.rfqservice.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.securisk.rfqservice.entity.CorporateDetails;
import com.ojas.securisk.rfqservice.entity.CorporateDetailsInput;
import com.ojas.securisk.rfqservice.service.CorporateDetailsRepository;
import com.ojas.securisk.rfqservice.service.CorporateDetailsService;

@Service
public class CorporatDetailsServiceImpl implements CorporateDetailsService {

	@Autowired
	private CorporateDetailsRepository repository;

	@Override
	public CorporateDetails corporateDetailsSave(CorporateDetailsInput corporateDetailsInput) {

		CorporateDetails corDetails = new CorporateDetails();
		BeanUtils.copyProperties(corporateDetailsInput, corDetails);
		CorporateDetails insert = repository.insert(corDetails);

		return insert;
	}

	@Override
	public List<CorporateDetails> getAllCorporateDetails() {
		// TODO Auto-generated method stub
		List<CorporateDetails> list = repository.findAll();

		return list;
	}

	@Override
	public CorporateDetails getCorporateDetailsById(String _id) {
		// TODO Auto-generated method stub
		CorporateDetails corporateDetails = repository.findById(_id).get();
		return corporateDetails;
	}

	@Override
	public String deleteCorporateDetailsById(String _id) {
		// TODO Auto-generated method stub
		String ms;
		if (_id != null) {
			ms = "Data is deleted.";
			repository.deleteById(_id);
		} else
			ms = "Data is not deleted";
		return ms;
	}

	@Override
	public CorporateDetails updateCorporateDetails(CorporateDetails corporateDetails) {
	//	CorporateDetails existingCorporateDetails = repository.findById(corporateDetails.get_id()).get();
		
		CorporateDetails updatedCorporateDetails =null;
	
		if( corporateDetails != null) {			
			updatedCorporateDetails = repository.save(corporateDetails);
		}
		
		
		
		return updatedCorporateDetails;

	}
}
