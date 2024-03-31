package com.javaexpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
		//findById
		// to retrieve data from non primary keys
	//select * from product where name='iphone11'
	
	Product findByName(String pname);
	
	Product findByPrice(double price);
	
	List<Product> findByPriceLessThan(double price);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByPriceOrderByAsc(double price);
	
	List<Product> findByPriceOrderByDesc(double price);
	
	List<Product> findByActiveTrue();
	
	List<Product> findByActiveFalse();
	
	List<Product> findByActive(boolean status);
	
	List<Product> findByCategoryName(String name);
	
	List<Product> findByNameContaining(String name);
}