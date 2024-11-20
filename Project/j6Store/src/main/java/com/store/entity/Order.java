package com.store.entity;

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
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Orders")
public class Order {
	@Id
	@Column(name="Id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="Username",referencedColumnName="Username")
	private Account account;
	
	@Column(name="CreateDate")
	private String createDate;
	
	@Column(name="Address")
	private String address;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;

}
