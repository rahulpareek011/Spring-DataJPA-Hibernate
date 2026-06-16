package com.rahulscripts.jpaTutorials.jpaTuts.globalresponsehandler;

import com.rahulscripts.jpaTutorials.jpaTuts.entities.ProductEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageableDataResponse {
    Integer pageNo;
    Integer totalPages;
    List<ProductEntity> data;
    Integer totalElements;
}
