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
	
	public List<Order> getOrders (boolean showAll) {
		List<Order> orders = new ArrayList<Order>();
		if(!showAll)
			OrderRepository.findOutstandingOrder().forEach(orders::add);
		else
			OrderRepository.findAll().forEach(orders::add);
		
		return orders; 
	}
	
	public List<Order> getOrdersForCustomer (String name, String phone) {
		List<Order> orders = new ArrayList<Order>();
			OrderRepository.findByNameAndPhoneOrderByStartTimeDesc(name, phone).forEach(orders::add);
		
		return orders; 
	}
	
	public Order getOrder(Integer id) {
		return OrderRepository.findById(id).get();
	}
	
	public Integer addOrder(Order Order) {
		return OrderRepository.save(Order).getId();
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
	
	public void serveOrder(Integer id, Date endTime) {
		OrderRepository.setServeTimeFor(id, endTime);
	}
}
