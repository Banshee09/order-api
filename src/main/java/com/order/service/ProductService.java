package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Product;
import com.order.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ProductRepository;
	
	public List<Product> getProducts () {
		List<Product> products = new ArrayList<Product>();
		ProductRepository.findAll().forEach(products::add);
		return products; 
	}
	
	public Product getProduct(Integer id) {
		return ProductRepository.findById(id).get();
	}
	
	public Integer addProduct(Product Product) {
		return ProductRepository.save(Product).getId();
	}

	public void editProduct(Integer id, Product Product) {
		ProductRepository.save(Product);
	}

	public void deleteProduct(Integer id) {
		ProductRepository.deleteById(id);
	}
	
}
