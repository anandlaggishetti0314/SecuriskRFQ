package com.ojas.securisk;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.junit.jupiter.api.Order;
import com.ojas.securisk.rfqservice.RfqServiceApplication;
import com.ojas.securisk.rfqservice.entity.CorporateDetails;
import com.ojas.securisk.rfqservice.repository.CorporateDetailsRepository;
import com.ojas.securisk.rfqservice.serviceImpl.CorporateDetailsServiceImpl;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Import(CorporateDetailsServiceImpl.class)

public class CorporateDetails_ServiceMethods_Tests {

	
	@Mock
	private CorporateDetailsRepository mockRepository;

  
	private CorporateDetailsServiceImpl serviceImpl;
	
	@Test
	@Order(1)
	public void testCorporateDetailsSave() {
		
		CorporateDetails corporateDetails =	 CorporateDetails.create("112", "Quantum Life", "Hyderabad", "Isurance", "Subbu",
			"subbu@gmail.com", 9555065553L, "Vinay", "Konda", "vinay@gmail.com", 9550355543L);
		when(mockRepository.insert(corporateDetails)).thenReturn(corporateDetails);
		
		serviceImpl = new CorporateDetailsServiceImpl(mockRepository);
		
		CorporateDetails result = serviceImpl.corporateDetailsSave(corporateDetails);
		
		assertEquals(corporateDetails, result);
		
	}
	
	@Test
	@Order(2)
	public void testGetAllCorporateDetails() {
		
		CorporateDetails corporateDetails =	 CorporateDetails.create("112", "Quantum Life", "Hyderabad", "Isurance", "Subbu",
				"subbu@gmail.com", 9555065553L, "Vinay", "Konda", "vinay@gmail.com", 9550355543L);
			
		CorporateDetails corporateDetails2 =	 CorporateDetails.create("112", "Quantum Life", "Hyderabad", "Isurance", "Subbu",
				"subbu@gmail.com", 9555065553L, "Vinay", "Konda", "vinay@gmail.com", 9550355543L);
		CorporateDetails corporateDetails3 =	 CorporateDetails.create("112", "Quantum Life", "Hyderabad", "Isurance", "Subbu",
				"subbu@gmail.com", 9555065553L, "Vinay", "Konda", "vinay@gmail.com", 9550355543L);
		List<CorporateDetails> list = Arrays.asList(corporateDetails,corporateDetails2,corporateDetails3);
		
		when(mockRepository.findAll()).thenReturn(list);
		
		serviceImpl = new CorporateDetailsServiceImpl(mockRepository);
		List<CorporateDetails> result = serviceImpl.getAllCorporateDetails();
		
		assertThat(list).isNotNull();
		assertThat(result.size()).isEqualTo(3);
	}
	
	
	@Test
	@Order(3)
	public void testUpdateCorporateDetails() {
		
		CorporateDetails corporateDetails =	 CorporateDetails.create("112", "Quantum Life", "Hyderabad", "Isurance", "Subbu",
			"subbu@gmail.com", 9555065553L, "Vinay", "Konda", "vinay@gmail.com", 9550355543L);
		when(mockRepository.insert(corporateDetails)).thenReturn(corporateDetails);
		
		corporateDetails.setInsuredName("Life Publications");
		corporateDetails.setEmailId("subbarao.kesa@gmail.com");
			
		serviceImpl = new CorporateDetailsServiceImpl(mockRepository);
		CorporateDetails updatedcorporateDetails = serviceImpl.updateCorporateDetails(corporateDetails);
		
		assertEquals(corporateDetails, updatedcorporateDetails);
		assertThat(updatedcorporateDetails.getInsuredName()).isEqualTo("Life Publications");
		assertThat(updatedcorporateDetails.getEmailId()).isEqualTo("subbarao.kesa@gmail.com");
		
	}
	
	
	@Test
	@Order(4)
	public void getCorporateDetailsById() {								
		
	 String id ="111";  
	 Optional<CorporateDetails> corporateDetails =	 Optional.ofNullable(CorporateDetails.create("111", "Quantum Life", "Hyderabad", "Isurance", "Subbu",
				"subbu@gmail.com", 9555065553L, "Vinay", "Konda", "vinay@gmail.com", 9550355543L));
			
	  when(mockRepository.findById(id)).thenReturn(corporateDetails);  
	  CorporateDetails result = serviceImpl.getCorporateDetailsById(id);
	  
	  assertThat(result).isNotNull();
	  assertEquals(corporateDetails.get(), result);
		
		
	}

	@Test
	@Order(5)
	public void deleteCorporateDetailsById() {								
		
	  String id ="111";
	  doNothing().when(mockRepository).deleteById(id);
	  serviceImpl.deleteCorporateDetailsById(id);
	  verify(mockRepository, times(1)).deleteById(id);
		
	}
	
}
