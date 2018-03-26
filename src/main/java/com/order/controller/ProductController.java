package com.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Product;
import com.order.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET, value="/products")
	public Map<String, Object> getProducts() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("products", productService.getProducts());
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}

	@RequestMapping(method=RequestMethod.GET, value="/products/{id}")
	public Map<String, Object> getProduct(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("product", productService.getProduct(id));
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public Map<String, Object> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.POST + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
	public Map<String, Object> editProduct(@PathVariable Integer id, @RequestBody Product product) {
		productService.editProduct(id, product);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.PUT + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
	public Map<String, Object> deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.DELETE + " successfully");
		return response;
	}
}
