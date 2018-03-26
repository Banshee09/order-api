package com.order.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Category;
import com.order.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategories () {
		List<Category> categories = new ArrayList<Category>();
		categoryRepository.findAll().forEach(categories::add);
		return categories; 
	}
	
	public Category getCategory(Integer id) {
		return categoryRepository.findById(id).get();
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	public void editCategory(Integer id, Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
	
}
