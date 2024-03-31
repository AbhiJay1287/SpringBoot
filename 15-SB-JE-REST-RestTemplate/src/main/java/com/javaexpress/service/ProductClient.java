package com.javaexpress.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.javaexpress.request.Category;
import com.javaexpress.request.Product;


@Service
public class ProductClient {
	
	private RestTemplate restTemplate = new RestTemplate(); 
	public Product createProduct(Product product) {
		try {
			String endpoint = "http://localhost:8080/api/v1/product";
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/json");
			headers.set("Content-Type", "application/json");
			
			HttpEntity<Product> httpEntity = new HttpEntity<>(product,headers);
		
			var responseEntity= restTemplate.exchange(endpoint,HttpMethod.POST,httpEntity,Product.class);
			
			if(responseEntity.getStatusCode().value()==200) {
				Product responseproduct = responseEntity.getBody();
				System.out.println(responseproduct.getName());
				return responseproduct;
			}
			
		}catch(HttpClientErrorException ex) {
			
		}catch(ResourceAccessException ex) {
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Something wrong");
		}
		return null;
	}
	
	public List<Category> fetchAllCategories() {
		try {
			String url = "http://localhost:8080/api/category";
			
			ResponseEntity<Category[]> responseEntity = 
					restTemplate.exchange(url, HttpMethod.GET, null,Category[].class);
			
			Category[] categories = responseEntity.getBody();
			List<Category> listOfCategories = Arrays.asList(categories);
			return listOfCategories
					.stream()
					.sorted(Comparator.comparing(Category::getName))
					.filter(c -> c.getName()!=null)
					.collect(Collectors.toList());
		}catch(Exception ex) {
			
		}
		return null;
	}
}
