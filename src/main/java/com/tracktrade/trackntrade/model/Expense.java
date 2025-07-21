package com.tracktrade.trackntrade.model;

import com.tracktrade.trackntrade.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Double value;
    private String category;
    private String color;

    @ManyToOne
    private User user;
}
