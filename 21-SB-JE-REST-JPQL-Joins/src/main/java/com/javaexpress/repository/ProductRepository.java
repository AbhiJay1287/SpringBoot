package com.javaexpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaexpress.dto.ProductCategoryDto;
import com.javaexpress.models.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	// findById
	//DSL
	
	// select * from product where name='iphone11'
	Product findByName(String pname);
	
	Product findByPrice(double price);
	
	// select * from product where name='iphone11' & price=950
	Product findByNameAndPrice(String pname,double price);
	
	Product findByNameOrPrice(String pname,double price);
	
	List<Product> findByPriceLessThan(double price);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByPriceOrderByNameAsc(double price);
	
	List<Product> findByPriceOrderByNameDesc(double price);
	
	List<Product> findByActiveTrue();
	
	List<Product> findByActiveFalse();
	
	List<Product> findByActive(boolean status);
	
	List<Product> findByCategoryName(String name);	
	
	List<Product> findByNameContaining(String name);
	
	
	// JPQL - method syntax not required becuse we are using @Query annotation 
	
	@Query("select p from Product p")
	List<Product> fetchAllProducts();
	
	@Query("select p from Product p where p.name=:productName")
	Product fetchProductbyName(String productName);
	
	@Query("select p from Product p INNER JOIN Category c on p.id=c.id")
	List<Product> fetchProductsUsingInnerJoin();
	
	@Query("select id,name,price from Product p where p.id=:id")
	List<Object[]> fetchProductDetailsUsingMultipleColumns(Integer id);
	
	@Query(value="select * from product",nativeQuery = true)
	List<Product> fetchAllProductsUsingNativeQuery();
	
	// calling stored procedures
	@Query(nativeQuery = true,value="call getAllProducsByName(:name)")
	List<Product> getAllProducts(String name);
	
	//MethodParam Binding
	@Query("select p from Product p where p.name=:productName and p.price=:productPrice")
	Product fetchProductbyNameAndPrice(String productName,double productPrice);
	
	//NamedParam Binding
	@Query("select p from Product p where p.name=:productName and p.price=:productPrice")
	Product fetchProductbyNameAndPriceNamedParam(@Param("pname") String productName,@Param("pprice")double productPrice);
	
	//PlaceHolders ?1 ?2 ?3
	@Query("select p from Product p where p.name=?1 and p.price=?2")
	Product fetchProductbyNameAndPricePlaceHolders(String productName,double productPrice);
	
	@Query(""" 
			select p from Product where p.name LIKE %?1% OR p.description LIKE %?1% OR p.category.name LIKE %?1%
			""")
	List<Product> fetchProducts(String keyword);
	
	//custom class as a Response
	@Query(" SELECT new com.javaexpress.dto.ProductCategoryDto(p.id,p.name,p.price,c.name)"
			+ " FROM Category c INNER JOIN c.products p")
	List<ProductCategoryDto> fetchProductCategoryInnerJoin();
	
	@Query(" SELECT new com.javaexpress.dto.ProductCategoryDto(p.id,p.name,p.price,c.name)"
			+ " FROM Category c INNER JOIN c.products p")
	List<ProductCategoryDto> fetchProductCategoryCrossJoin();
	
	@Transactional
	@Query("update Product p SET p.active=?2 where p.id=?1")
	public void updateProductStatus(Integer id,boolean enabled);
}