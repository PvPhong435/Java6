package com.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Authorities")
public class Authority {
	@Id
	private Integer Id;
	
	@Column(name = "Username")
	private String username;
	
	@ManyToOne
	@JoinColumn(name="RoleId")
	private Role authRole;
}
