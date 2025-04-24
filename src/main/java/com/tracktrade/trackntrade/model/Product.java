package com.tracktrade.trackntrade.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer quantity;
    private Double unitPrice;
    private Integer lowStockThreshold;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;
}
