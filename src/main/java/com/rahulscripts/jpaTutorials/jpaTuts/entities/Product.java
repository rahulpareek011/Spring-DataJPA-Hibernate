package com.rahulscripts.jpaTutorials.jpaTuts.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        schema = "rp",
        name = "product_table",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique",columnNames = "sku"),
                @UniqueConstraint(name = "title_price_unique",columnNames = {"title_x","price"})//Composite Unique Constraint
                                                                                    // (ensures the combination of multiple columns remains unique).
        },
        indexes = {
                @Index(name = "sku_index",columnList = "sku")
        }
)
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String sku;

    @Column(name = "title_x")
    private String title;

    private BigDecimal price;

    private Long quantity;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
