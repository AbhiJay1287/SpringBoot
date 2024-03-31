package com.javaexpress.service;

import org.springframework.data.domain.PageRequest;

import com.javaexpress.models.Product;
import com.javaexpress.service.responses.ProductBoResponse;

public interface ProductService {

	public Product createProduct(Product product);
	public ProductBoResponse fetchProductsUsingPagination(PageRequest pageRequest);
	public Product fetchProduct(String name);
	public Product fetchProduct(double price);
}