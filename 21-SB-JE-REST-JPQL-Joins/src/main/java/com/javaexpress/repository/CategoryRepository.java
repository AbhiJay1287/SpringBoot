package com.javaexpress.repository;


import com.javaexpress.dto.ProductCategoryDto;
//import java.util.Locale.Category;
import com.javaexpress.models.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	@Query(" SELECT new com.javaexpress.dto.ProductCategoryDto(p.id,p.name,p.price,c.name)"
			+ " FROM Category c LEFT JOIN c.products p")
	List<ProductCategoryDto> fetchProductCategoryLeftJoin();
	
	@Query(" SELECT new com.javaexpress.dto.ProductCategoryDto(p.id,p.name,p.price,c.name)"
			+ " FROM Category c RIGHT  JOIN c.products p")
	List<ProductCategoryDto> fetchProductCategoryRightJoin();
}
 