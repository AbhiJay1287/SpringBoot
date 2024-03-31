package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		
		@GetMapping
		public List<Category> fetchCategories() {
			return categoryService.fetchAllCategories();
		}
		
		@GetMapping(value="/{id}")
		public Category fetchCategory(@PathVariable("id") Integer categoryId) {
			return categoryService.fetchCategory(categoryId);
		}
		
		@GetMapping(value="/categoryId")
		public Category fetchCategory1(@RequestParam("id") Integer categoryId) {
			return categoryService.fetchCategory(categoryId);
		}
		
		@PutMapping(value="/{id}")
		public Category updateCategory(@PathVariable("id") Integer categoryId,@RequestBody Category category) {
			return categoryService.updateCategory(categoryId, category);
		}
		
		@DeleteMapping(value=("/{id}"))
		public void deleteCategory(@PathVariable("id") Integer categoryId) {
			categoryService.deleteCategory(categoryId);
			}
}
