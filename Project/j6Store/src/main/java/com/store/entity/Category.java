package com.store.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Categories")
public class Category {
	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="Name")
	private String name;
	
	@OneToMany(mappedBy = "prodCategory",cascade = CascadeType.ALL)
	private List<Product> products;
}
