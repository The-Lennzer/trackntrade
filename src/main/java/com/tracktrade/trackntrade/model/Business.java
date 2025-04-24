package com.tracktrade.trackntrade.model;

import com.tracktrade.trackntrade.model.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "businesses")
public class Business {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "business")
    private List<User> users;

    @OneToMany(mappedBy = "business")
    private List<Product> products;

    @OneToMany(mappedBy = "business")
    private List<Trade> trades;
}
