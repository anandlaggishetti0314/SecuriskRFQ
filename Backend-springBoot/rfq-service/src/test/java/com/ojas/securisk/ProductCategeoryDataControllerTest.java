package com.ojas.securisk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ojas.securisk.rfqservice.controller.ProductCategeoryDataController;
import com.ojas.securisk.rfqservice.entity.ProductCategeoryData;
import com.ojas.securisk.rfqservice.serviceImpl.ProductCategeoryDataServiceImpl;

@SpringBootTest
public class ProductCategeoryDataControllerTest {

	@Mock
	private ProductCategeoryDataServiceImpl productService;

	@InjectMocks
	private ProductCategeoryDataController productController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@Order(1)
	public void testCreateCategoryWithProductName() {
		ProductCategeoryData categoryData = new ProductCategeoryData();
		categoryData.setProductCategeory("testing");
		categoryData.setProductName(Arrays.asList("hgg", "jhk"));

		String result = productController.createCategeory(categoryData);
		assertEquals("success", result);
	}

	@Test
	public void testCreateCategoryWithoutProductNameAndEB() {
		ProductCategeoryData categoryData = new ProductCategeoryData();
		categoryData.setProductCategeory("Electronics");

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> productController.createCategeory(categoryData));
		assertEquals("Product name is mandatory when eb is not selected.", exception.getMessage());
	}

	@Test
	public void testCreateCategoryWithoutProductNameButWithEB() {
		ProductCategeoryData categoryData = new ProductCategeoryData();
		categoryData.setProductCategeory("Electronics");
		categoryData.setId("fff");

		String result = productController.createCategeory(categoryData);
		assertEquals("success", result);
	}

	@Test
	public void testCreateCategoryWithEmptyProductCategory() {
		ProductCategeoryData categoryData = new ProductCategeoryData();
		categoryData.setProductCategeory("");
		categoryData.setProductName((Arrays.asList("hgg", "jhk")));

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> productController.createCategeory(categoryData));
		assertEquals("Product category is mandatory.", exception.getMessage());
	}

	@Test
	public void testCreateCategoryWithNullProductCategory() {
		ProductCategeoryData categoryData = new ProductCategeoryData();
		categoryData.setProductCategeory("fhjhghjfgjh");
		categoryData.setProductName(Arrays.asList("hgg", "jhk"));

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> productController.createCategeory(categoryData));
		assertEquals("Product category is mandatory.", exception.getMessage());
	}

	@Test
	public void testGetAllCategoriesEmptyList() {
		when(productService.getAllcategeoryDetails()).thenReturn(Collections.emptyList());

		List<ProductCategeoryData> result = productController.getAllcategeory();
		assertEquals(0, result.size());
	}

	@Test
	public void testGetAllCategoriesNonEmptyList() {
		List<ProductCategeoryData> mockCategories = new ArrayList<>();
		mockCategories.add(new ProductCategeoryData("Electronics", "Product A", Arrays.asList("hgg", "jhk")));
		mockCategories.add(new ProductCategeoryData("Furniture", "Product B", Arrays.asList("hgg", "jhk")));

		when(productService.getAllcategeoryDetails()).thenReturn(mockCategories);

		List<ProductCategeoryData> result = productController.getAllcategeory();
		assertEquals(2, result.size());
	}
}