package com.sof306.lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Products")
public class Product implements Serializable {

    @Id
    private String id;
    @Column(name="Name")
    private String name;
    @Column(name="Price")
    private Double price;
    @Column(name="Image")
    private String img;
    @Temporal(TemporalType.DATE)
    @Column(name="CreateDate")
    private Date createDate = new Date();
    private Boolean available;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

}
