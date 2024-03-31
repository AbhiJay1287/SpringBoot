package com.javaexpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javaexpress.models.Category;
import com.javaexpress.service.CategoryService;

@SpringBootApplication
public class Application implements ApplicationRunner{
	
	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
 
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		createCategory();
		fetchCategory();
//		updateCategory();
//		deleteCategory();
	}

	private void deleteCategory() {
		categoryService.deleteCategory(2);
	}

	private void updateCategory() {
		Category inputCategory = new Category();
		inputCategory.setName("Clothes_modified");
		categoryService.updateCategory(2, inputCategory);
	}

	private void fetchCategory() {
		Category dbCategory = categoryService.fetchCategory(1);
		System.out.println(dbCategory.getName()+" "+dbCategory.getId());
	}

	private void createCategory() {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setName("Clothes");
		
		categoryService.createCategory(category);
	}

}
