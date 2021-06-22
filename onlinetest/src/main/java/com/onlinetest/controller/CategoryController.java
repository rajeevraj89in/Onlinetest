package com.onlinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetest.entity.exam.Category;
import com.onlinetest.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Add Category

	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		Category cat = this.categoryService.addCategory(category);
		return ResponseEntity.ok(cat);
	}

	// Get Single Category

	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategory(categoryId);
	}

	// Get All Category

	@GetMapping("/")
	public ResponseEntity<?> getCategories() {
		return ResponseEntity.ok(this.categoryService.getCategories());
	}

	// Update Category

	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}

	// Delete Category

	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		this.categoryService.deleteCategory(categoryId);
	}

}
