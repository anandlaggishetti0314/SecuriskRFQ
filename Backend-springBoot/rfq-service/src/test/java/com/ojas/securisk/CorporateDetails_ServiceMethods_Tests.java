package com.ojas.securisk;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.ojas.securisk.rfqservice.RfqServiceApplication;
import com.ojas.securisk.rfqservice.serviceImpl.CorporateDetailsServiceImpl;

@SpringBootTest(classes = RfqServiceApplication.class)
@AutoConfigureHttpGraphQlTester
@Import(CorporateDetailsServiceImpl.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@RunWith(PowerMockRunner.class)
public class CorporateDetails_ServiceMethods_Tests {
	
	
	
	
	
	
	
//	
//	@Test
//	public void testGetNameByUserId() {
//		UserDao mockDao = PowerMockito.mock(UserDao.class);
//		PowerMockito.when(mockDao.findNameById(101)).thenReturn("Nick");
//		PowerMockito.when(mockDao.findNameById(102)).thenReturn("Smith");
//
//		UserService service = new UserService(mockDao);
//		String name = service.getNameByUserId(101);
//		assertEquals("Nick", name);
//	}
//
//	@Test
//	public void testGetEmailByUserId() {
//		UserDao mockDao = PowerMockito.mock(UserDao.class);
//
//		PowerMockito.when(mockDao.findEmailById(101)).thenCallRealMethod();
//
//		UserService service = new UserService(mockDao);
//
//		String email = service.getEmailByUserId(101);
//
//		assertEquals("john.k@gmail.com", email);
//	}
//
//	@Test
//	public void testDoProcess() {
//		UserService mockService = PowerMockito.mock(UserService.class);
//		try {
//			PowerMockito.doNothing().when(mockService, "pushMsgToKafkaTopic", anyString());
//			mockService.doProcess();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testDoWorkWithPrivateMethodMock() throws Exception {
//		UserService service = new UserService();
//		UserService spy = PowerMockito.spy(service);
//		PowerMockito.doReturn("TEST MSG").when(spy, "formatMsg", "test msg");
//		String formattedMsg = service.doWork("test msg");
//		assertEquals("TEST MSG", formattedMsg);
//	}
//	
//	
//	
//	
//	
	
	

}
