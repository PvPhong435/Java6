package com.store.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Products")
public class Product {
	@Id
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Image")
	private String image;
	
	@Column(name="Price")
	private String price;
	
	@Column(name="CreateDate")
	private Date createDate;
	
	@Column(name="Available")
	private Boolean avaliable;
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category prodCategory;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
}
