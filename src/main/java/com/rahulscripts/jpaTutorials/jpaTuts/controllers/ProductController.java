package com.rahulscripts.jpaTutorials.jpaTuts.controllers;

import com.rahulscripts.jpaTutorials.jpaTuts.entities.ProductEntity;
import com.rahulscripts.jpaTutorials.jpaTuts.repositories.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final Integer PAGE_SIZE = 5;
    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> findAll(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "0") Integer pageNo){
        //return productRepository.findBy(Sort.by(Sort.Direction.ASC,sortBy,"price"));
//        return productRepository.findBy(
//                Sort.by(
//                        Sort.Order.asc(sortBy),
//                        Sort.Order.desc("Price")
//                )
//        );
        Pageable page = PageRequest.of(pageNo,PAGE_SIZE,
                Sort.by(
                    Sort.Order.asc(sortBy),
                    Sort.Order.asc("price")
                )
        );
        return productRepository.findAll(page).getContent();
    }
}
