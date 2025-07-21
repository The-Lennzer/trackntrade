package com.tracktrade.trackntrade.model;

import com.tracktrade.trackntrade.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyFund {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private YearMonth month; // Store as YYYY-MM

    private Double value;

    @ManyToOne
    private User user;
}
