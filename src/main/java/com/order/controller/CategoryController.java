package com.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Category;
import com.order.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method=RequestMethod.GET, value="/categories")
	public Map<String, Object> getCategories() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("categories", categoryService.getCategories());
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}

	@RequestMapping(method=RequestMethod.GET, value="/categories/{id}")
	public Map<String, Object> getCategory(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("category", categoryService.getCategory(id));
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categories")
	public Map<String, Object> addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.POST + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/categories/{id}")
	public Map<String, Object> editCategory(@PathVariable Integer id, @RequestBody Category category) {
		categoryService.editCategory(id, category);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.PUT + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/categories/{id}")
	public Map<String, Object> deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.DELETE + " successfully");
		return response;
	}
}
