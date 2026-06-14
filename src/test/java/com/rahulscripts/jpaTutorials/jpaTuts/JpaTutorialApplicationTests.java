package com.rahulscripts.jpaTutorials.jpaTuts;

import com.rahulscripts.jpaTutorials.jpaTuts.entities.ProductEntity;
import com.rahulscripts.jpaTutorials.jpaTuts.repositories.ProductRepository;
import jakarta.annotation.Priority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findAllProducts(){
		List<ProductEntity> productEntities = productRepository.findAll();
		System.out.println(productEntities);
	}


	@Test
	void getSingleValue(){
		ProductEntity productEntity = ProductEntity.builder()
				.price(BigDecimal.valueOf(100))
				.createdAt(LocalDateTime.now())
				.sku("coca")
				.quantity(10L)
				.title("Coca cola")
				.build();
		productRepository.save(productEntity);
	}


	@Test
	void createProduct(){
		List<ProductEntity> productEntity = productRepository.getByTitleAndPrice("Coca cola",BigDecimal.valueOf(100.00));
		System.out.println(productEntity);
	}
}
