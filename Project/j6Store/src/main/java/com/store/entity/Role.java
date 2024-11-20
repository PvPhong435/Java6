package com.store.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Roles")
public class Role {
	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name = "Name")
	private String name;
	
	@OneToMany(mappedBy = "authRole",cascade = CascadeType.ALL)
	private List<Authority> authList;
}
