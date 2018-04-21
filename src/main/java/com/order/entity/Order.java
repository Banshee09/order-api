package com.order.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="ord")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String phone;
	private Double total;
	private String note;
	private Date startTime;
	private Date serveTime;
	private Date payTime;

	@ManyToMany
	private List<Product> products = new ArrayList<Product>();

	public Order() {
		super();
	}

	public Order(Integer id, String name, String phone, Double total, String note, Date startTime, Date serveTime,
			Date payTime, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.total = total;
		this.note = note;
		this.startTime = startTime;
		this.serveTime = serveTime;
		this.payTime = payTime;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getServeTime() {
		return serveTime;
	}

	public void setServeTime(Date serveTime) {
		this.serveTime = serveTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


}
