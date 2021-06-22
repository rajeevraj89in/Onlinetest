package com.onlinetest.services.implementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.entity.exam.Category;
import com.onlinetest.repository.CategoryRepository;
import com.onlinetest.services.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long CategoryId) {
		Category category = new Category();
		category.setCid(CategoryId);
		this.categoryRepository.delete(category);
	}

}
