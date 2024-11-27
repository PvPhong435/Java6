package com.lab5.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="orderDetails")
public class OrderDetails {
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name="OrderId")
	Orders order;
	@ManyToOne
	@JoinColumn(name="ProductId")
	Products product;
}
