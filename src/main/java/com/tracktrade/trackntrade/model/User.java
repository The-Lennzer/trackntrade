package com.tracktrade.trackntrade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;
    private String password;
    private Double monthlyIntake;
    private Double savings;

    @Enumerated(EnumType.STRING)
    private MonthMode monthMode; // fresh | cumulative

    public enum MonthMode {
        FRESH,
        CUMULATIVE
    }
}
