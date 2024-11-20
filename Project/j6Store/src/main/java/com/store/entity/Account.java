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
@Table(name="Accounts")
public class Account {
	@Id
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Fullname")
	private String fullname;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Photo")
	private String photo;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private List<Order> orders;
	
	
}
