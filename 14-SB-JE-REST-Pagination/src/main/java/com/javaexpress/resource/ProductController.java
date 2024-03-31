package com.javaexpress.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.models.Product;
import com.javaexpress.service.ProductService;
import com.javaexpress.service.responses.ProductBoResponse;

@RestController
@RequestMapping(value="/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping(value="/pagination")
	public ProductBoResponse fetchProducts(
		@RequestParam(value="pageNumber", required = false,defaultValue= "0") int pageNumber,
		@RequestParam(value="pageNumber", required = false,defaultValue= "0") int noOfRecords,
		@RequestParam(value="sort", required = false,defaultValue= "0") String sort
			) {
		if(sort.equals("ASC")) {
			return productService.fetchProductsUsingPagination(PageRequest.of(pageNumber, noOfRecords, Direction.ASC, "price"));
		}
		else {
			return productService.fetchProductsUsingPagination(PageRequest.of(pageNumber, noOfRecords, Direction.DESC, "price"));
		}
	}
	//http:://localHost:8080/api/v1/product/pagination
	
	//http:://localHost:8000/api/v1/product/pagination?pageNumber=3
	
	//http:://localHost:8000/api/v1/product/pagination?noOfRecords=7
	
	//http:://localHost:8000/api/v1/product/pagination?sort=ASC
}