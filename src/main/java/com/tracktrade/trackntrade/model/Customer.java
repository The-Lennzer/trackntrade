package com.tracktrade.trackntrade.model;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;
    private String contactEmail;
}
