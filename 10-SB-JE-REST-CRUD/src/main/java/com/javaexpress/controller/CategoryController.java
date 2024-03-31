package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.models.Category;
import com.javaexpress.service.CategoryService;

@RestController
@RequestMapping(value="/api/category") 
public class CategoryController {

		@Autowired
		private CategoryService categoryService;
	
		@PostMapping
		public void createCatgory(@RequestBody Category category) {
			categoryService.createCategory(category);
		}
}
