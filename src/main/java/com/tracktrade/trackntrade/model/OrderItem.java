package com.tracktrade.trackntrade.model;

import jakarta.persistence.*;

@Entity
@Table(name="orderitems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Trade trade;
}
