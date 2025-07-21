package com.tracktrade.trackntrade.service;

import com.tracktrade.trackntrade.model.MonthlyFund;
import com.tracktrade.trackntrade.model.User;
import com.tracktrade.trackntrade.repo.MonthlyFundRepository;
import com.tracktrade.trackntrade.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MonthlyFundService {

    private final MonthlyFundRepository fundRepository;
    private final UserRepository userRepository;

    public MonthlyFund addFund(UUID userId, YearMonth month, Double amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Use default if amount is null
        if (amount == null) {
            amount = user.getMonthlyIntake();
        }

        MonthlyFund fund = fundRepository.findByUserAndMonth(user, month)
                .orElse(new MonthlyFund());

        fund.setUser(user);
        fund.setMonth(month);
        fund.setValue(amount);

        return fundRepository.save(fund);
    }

    public User updateMonthlyIntake(UUID userId, Double newIntake) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setMonthlyIntake(newIntake);
        return userRepository.save(user);
    }

    public List<MonthlyFund> getAllFunds(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return fundRepository.findAllByUser(user);
    }
}
