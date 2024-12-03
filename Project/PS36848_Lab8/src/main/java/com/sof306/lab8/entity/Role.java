package com.sof306.lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "authorities")
@ToString(exclude = "authorities")
@Entity
@Table(name="Roles")
public class Role {

    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Authority> authorities;

}
