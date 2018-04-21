package com.order.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.order.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Modifying
	@Transactional
	@Query("update ord set pay_time = ?2 where id = ?1")
	int setPayTimeFor(Integer id, Date payTime);
	
	@Modifying
	@Transactional
	@Query("update ord set serve_time = ?2 where id = ?1")
	int setServeTimeFor(Integer id, Date serveTime);
	
	@Query("select o from ord o where o.payTime is null or o.serveTime is null")
	List <Order> findOutstandingOrder();
	
	List <Order> findByNameAndPhoneOrderByStartTimeDesc(String name, String phone);
}
