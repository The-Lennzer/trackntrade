package com.tracktrade.trackntrade.repo;

import com.tracktrade.trackntrade.model.Expense;
import com.tracktrade.trackntrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
    List<Expense> findAllByUserAndCreatedAtBetween(User user, LocalDateTime start, LocalDateTime end);
}
