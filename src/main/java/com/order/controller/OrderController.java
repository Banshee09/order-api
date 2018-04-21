package com.order.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.common.KeyValuePair;
import com.order.entity.Order;
import com.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/orders")
	public Map<String, Object> getOrders(@RequestParam boolean showAll) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("orders", orderService.getOrders(showAll));
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/orders/customer")
	public Map<String, Object> getOrdersForCustomer(@RequestParam String name, @RequestParam String phone) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("orders", orderService.getOrdersForCustomer(name, phone));
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/orders/{id}")
	public Map<String, Object> getOrder(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("order", orderService.getOrder(id));
		response.put("message", RequestMethod.GET + " successfully");
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/orders")
	public Map<String, Object> addOrder(@RequestBody Order order) {
		order.setStartTime(new Date());
		Integer id = orderService.addOrder(order);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.POST + " successfully");
		response.put("id", id);
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT, value="/orders/{id}")
	public Map<String, Object> editOrder(@PathVariable Integer id, @RequestBody Order order) {
		orderService.editOrder(id, order);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.PUT + " successfully");
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.DELETE, value="/orders/{id}")
	public Map<String, Object> deleteOrder(@PathVariable Integer id) {
		orderService.deleteOrder(id);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.DELETE + " successfully");
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PATCH, value="/orders/{id}")
	public Map<String, Object> editOrder(@PathVariable Integer id, @RequestBody KeyValuePair change) {
		if(change.getKey().equals("payTime"))
			orderService.payOrder(id, new Date());
		if(change.getKey().equals("serveTime"))	
			orderService.serveOrder(id, new Date());
			
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", RequestMethod.PATCH + " successfully");
		return response;
	}
}
