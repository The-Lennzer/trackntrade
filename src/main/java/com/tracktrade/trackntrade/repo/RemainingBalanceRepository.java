package com.tracktrade.trackntrade.repo;

import com.tracktrade.trackntrade.model.RemainingBalance;
import com.tracktrade.trackntrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RemainingBalanceRepository extends JpaRepository<RemainingBalance, UUID> {
    Optional<RemainingBalance> findByUserAndMonth(User user, YearMonth month);
}
