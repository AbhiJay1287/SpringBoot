package com.javaexpress.request;

import java.sql.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class Product {
	
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private boolean active;
	
	private String description;
	
	private Category category;
}
