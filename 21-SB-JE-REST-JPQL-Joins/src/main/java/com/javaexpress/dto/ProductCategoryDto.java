package com.javaexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductCategoryDto {
	private Integer id;
	
	private String productName;
	
	private double price;
	
	private String productCategory;
	
}
