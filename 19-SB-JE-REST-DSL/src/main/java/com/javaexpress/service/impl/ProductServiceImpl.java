package com.javaexpress.service.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javaexpress.models.Category;
import com.javaexpress.models.Product;
import com.javaexpress.models.Status;
import com.javaexpress.repository.ProductRepository;
import com.javaexpress.service.CategoryService;
import com.javaexpress.service.ProductService;
import com.javaexpress.service.responses.ProductBoResponse;

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

	
	public ProductBoResponse fetchProductsUsingPagination(PageRequest pageRequest) {
		Page<Product> page = productRepository.findAll(pageRequest);
		
		ProductBoResponse response = new 
				ProductBoResponse(page.getTotalPages(),page.getTotalElements(),page.getContent());
		 
		return response;
	}


	@Override
	public Product fetchProduct(String name) {
		// TODO Auto-generated method stub
		return  productRepository.findByName(name);
	}


	@Override
	public Product fetchProduct(double price) {
		// TODO Auto-generated method stub
		return productRepository.findByPrice(price);
	}
}