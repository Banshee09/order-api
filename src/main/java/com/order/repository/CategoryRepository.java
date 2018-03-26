package com.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.order.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
