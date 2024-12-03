package com.sof306.lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account {

    @Id
    @Column(name="Username")
    private String username;
    @Column(name="Password")
    private String password;
    @Column(name="Fullname")
    private String fullname;
    @Column(name="Email")
    private String email;
    @Column(name="Photo")
    private String img;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Order> orders;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Authority> authorities;

}
