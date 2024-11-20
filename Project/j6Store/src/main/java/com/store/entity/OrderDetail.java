package com.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="OrderDetails")
public class OrderDetail {
	@Id
	@Column(name="Id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="OrderId",referencedColumnName="Id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="ProductId", referencedColumnName = "Id")
	private Product product;
	
	@Column(name="Price")
	private Float price;
	
	@Column(name="Quantity")
	private Integer quantity;
}
