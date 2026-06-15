package com.rahulscripts.jpaTutorials.jpaTuts.repositories;

import com.rahulscripts.jpaTutorials.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findBy(Sort sort);

    @Query("Select e from ProductEntity e where e.title = ?1 and e.price = ?2")
    List<ProductEntity> getByTitleAndPrice(String title, BigDecimal price);
}
