package com.tracktrade.trackntrade.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private TradeType type; // SALE or PURCHASE

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "trade", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @ManyToOne
    private Business business;

    public enum TradeType {
        SALE,
        PURCHASE
    }
}
