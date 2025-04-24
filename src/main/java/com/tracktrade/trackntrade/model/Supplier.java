package com.tracktrade.trackntrade.model;

import jakarta.persistence.*;

@Entity
@Table(name="suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactEmail;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;
}
