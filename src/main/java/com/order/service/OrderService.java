package com.order.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository OrderRepository;
	
	public List<Order> getOrders () {
		List<Order> orders = new ArrayList<Order>();
		OrderRepository.findAll().forEach(orders::add);
		return orders; 
	}
	
	public Order getOrder(Integer id) {
		return OrderRepository.findById(id).get();
	}
	
	public void addOrder(Order Order) {
		OrderRepository.save(Order);
	}

	public void editOrder(Integer id, Order Order) {
		OrderRepository.save(Order);
	}

	public void deleteOrder(Integer id) {
		OrderRepository.deleteById(id);
	}
	
	public void payOrder(Integer id, Date payTime) {
		OrderRepository.setPayTimeFor(id, payTime);
	}
	
	public void endOrder(Integer id, Date endTime) {
		OrderRepository.setEndTimeFor(id, endTime);
	}
}
