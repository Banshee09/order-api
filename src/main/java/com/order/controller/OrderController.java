package com.order.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.common.KeyValuePair;
import com.order.entity.Order;
import com.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET, value="/orders")
	public Map<String, Object> getOrders() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("orders", orderService.getOrders());
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}

	@RequestMapping(method=RequestMethod.GET, value="/orders/{id}")
	public Map<String, Object> getOrder(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("order", orderService.getOrder(id));
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/orders")
	public Map<String, Object> addOrder(@RequestBody Order order) {
		order.setStartTime(new Date());
		orderService.addOrder(order);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.POST + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/orders/{id}")
	public Map<String, Object> editOrder(@PathVariable Integer id, @RequestBody Order order) {
		orderService.editOrder(id, order);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.PUT + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/orders/{id}")
	public Map<String, Object> deleteOrder(@PathVariable Integer id) {
		orderService.deleteOrder(id);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.DELETE + " successfully");
		return response;
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/orders/{id}")
	public Map<String, Object> editOrder(@PathVariable Integer id, @RequestBody KeyValuePair change) {
		if(change.getKey().equals("payTime"))
			orderService.payOrder(id, new Date());
		if(change.getKey().equals("endTime"))	
			orderService.endOrder(id, new Date());
			
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.PATCH + " successfully");
		return response;
	}
}
