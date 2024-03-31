package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.request.Category;
import com.javaexpress.request.Product;
import com.javaexpress.service.ProductClient;

@RestController
public class ProductClientController {
	
	@Autowired
	private ProductClient productClient;
	
	@PostMapping("/client")
	public Product createProduct(@RequestBody Product product) {
		return productClient.createProduct(product);
	}
	
	@GetMapping("/category")
	public List<Category> fetchCategories() {
		return productClient.fetchAllCategories();
	}
}
