package com.order.repository;

import java.util.Date;

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
	@Query("update ord set end_time = ?2 where id = ?1")
	int setEndTimeFor(Integer id, Date endTime);
	
}
