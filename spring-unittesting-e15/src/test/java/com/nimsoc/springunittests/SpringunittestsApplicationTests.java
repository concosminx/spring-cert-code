package com.nimsoc.springunittests;

import com.nimsoc.springunittests.repositories.ProductRepository;
import com.nimsoc.springunittests.services.ProductService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class SpringunittestsApplicationTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;


	//find the cases
	@Test
	public void noProductsReturnedTest() {
		given(productRepository.getProductNames()).willReturn(Collections.EMPTY_LIST);

		List<String> result = productService.getProductNamesWithEvenNumberOfChars();

		assertTrue(result.isEmpty());
	}

	@Test
	public void moreProductsAreFoundInTheDatabase() {
		List<String> input = Arrays.asList("aa", "bbbb", "ccc");

		given(productRepository.getProductNames()).willReturn(input);

		List<String> result = productService.getProductNamesWithEvenNumberOfChars();

		assertEquals(2, result.size());

		//check if a method is called
		//verify(productRepository, times(1)).getProductNames();
	}


	//@Test
	//void contextLoads() {
	//}

	//@Before or @BeforeEach- each of the test
	//@BeforeClass or @BeforeAll - each class
	//@After -
	//@AfterClass -


}
