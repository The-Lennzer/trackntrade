package com.tracktrade.trackntrade.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    public enum Role {
        ADMIN,
        MANAGER,
        STAFF
    }
}
