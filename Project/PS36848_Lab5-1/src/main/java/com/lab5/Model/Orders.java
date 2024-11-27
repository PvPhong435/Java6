package com.lab5.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="orders")
public class Orders {
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name="Username")
	Accounts account;
	private String createDate;
	private String address;
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetails> orderDetails;
	
	
}
