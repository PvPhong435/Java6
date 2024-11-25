package com.lab5.Model;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Student")
public class Student {
	@Id
	private String email;
	private String fullname;
	private Double marks;
	private Boolean gender;
	private String country;
}
