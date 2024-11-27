package com.lab5.Model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="products")
public class Products {
	@Id
	private String id;
	private String name;
	private String image;
	private Double price;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Boolean available;
	@ManyToOne
	@JoinColumn(name="CategoryId")
	Categories category;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetails> orderDetails;
	
	
}
