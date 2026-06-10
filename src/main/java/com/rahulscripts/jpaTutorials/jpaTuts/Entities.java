package com.rahulscripts.jpaTutorials.jpaTuts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Entities {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String sku;

    private String title;

    private BigDecimal price;

    private Long quantity;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
