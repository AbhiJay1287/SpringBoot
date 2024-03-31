package com.javaexpress.service.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.models.Category;
import com.javaexpress.models.Product;
import com.javaexpress.models.Status;
import com.javaexpress.repository.ProductRepository;
import com.javaexpress.service.CategoryService;
import com.javaexpress.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		Category dbCategory = 
				categoryService.fetchCategory(product.getCategory().getId());
		product.setCategory(dbCategory);
		product.setStatus(Status.NEW);
		return productRepository.save(product);
	}

	
}