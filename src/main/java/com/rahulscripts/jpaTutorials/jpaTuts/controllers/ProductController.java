package com.rahulscripts.jpaTutorials.jpaTuts.controllers;

import com.rahulscripts.jpaTutorials.jpaTuts.entities.ProductEntity;
import com.rahulscripts.jpaTutorials.jpaTuts.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> findAll(@RequestParam(defaultValue = "id") String sortBy){
        //return productRepository.findBy(Sort.by(Sort.Direction.ASC,sortBy,"price"));
        return productRepository.findBy(
                Sort.by(
                        Sort.Order.asc(sortBy),
                        Sort.Order.desc("Price")
                )
        );
    }
}
