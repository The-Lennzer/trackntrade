package com.tracktrade.trackntrade.repo;

import com.tracktrade.trackntrade.model.MonthlyFund;
import com.tracktrade.trackntrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MonthlyFundRepository extends JpaRepository<MonthlyFund, UUID> {
    Optional<MonthlyFund> findByUserAndMonth(User user, YearMonth month);
    List<MonthlyFund> findAllByUser(User user);
}
