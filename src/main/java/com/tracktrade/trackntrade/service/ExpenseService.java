package com.tracktrade.trackntrade.service;

import com.tracktrade.trackntrade.model.*;
import com.tracktrade.trackntrade.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final RemainingBalanceRepository balanceRepository;
    private final MonthlyFundRepository fundRepository;
    private final LiabilityRepository liabilityRepository;
    private final UserRepository userRepository;

    public Expense addExpense(UUID userId, Double value, String category, String color) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        YearMonth month = YearMonth.now(); // Assume current month
        RemainingBalance balance = balanceRepository.findByUserAndMonth(user, month)
                .orElseThrow(() -> new RuntimeException("Balance not initialized"));

        // Deduct from balance
        balance.setValue(balance.getValue() - value);
        balanceRepository.save(balance);

        Expense expense = new Expense();
        expense.setUser(user);
        expense.setValue(value);
        expense.setCategory(category);
        expense.setColor(color);
        expense.setCreatedAt(LocalDateTime.now());
        expense.setUpdatedAt(LocalDateTime.now());

        return expenseRepository.save(expense);
    }

    public RemainingBalance initializeBalance(UUID userId, YearMonth month) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MonthlyFund fund = fundRepository.findByUserAndMonth(user, month)
                .orElseThrow(() -> new RuntimeException("Monthly fund not found"));

        List<Liability> liabilities = liabilityRepository.findAllByUser(user);
        double totalLiabilities = liabilities.stream()
                .mapToDouble(Liability::getValue).sum();

        double savings = user.getSavings() != null ? user.getSavings() : 0.0;

        double spendable = fund.getValue() - totalLiabilities - savings;

        RemainingBalance balance = new RemainingBalance();
        balance.setUser(user);
        balance.setMonth(month);
        balance.setValue(spendable);

        return balanceRepository.save(balance);
    }

    public Map<String, Object> getFinanceReport(UUID userId, YearMonth month) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RemainingBalance balance = balanceRepository.findByUserAndMonth(user, month)
                .orElseThrow(() -> new RuntimeException("Balance not found"));

        double current = balance.getValue();
        double originalSpendable = user.getMonthlyIntake() - user.getSavings()
                - liabilityRepository.findAllByUser(user).stream().mapToDouble(Liability::getValue).sum();

        boolean isCritical = current < (0.10 * originalSpendable);

        Map<String, Object> response = new HashMap<>();
        response.put("spendable", current);
        response.put("critical", isCritical);
        response.put("expenses", expenseRepository.findAllByUserAndCreatedAtBetween(
                user,
                month.atDay(1).atStartOfDay(),
                month.atEndOfMonth().atTime(LocalTime.MAX)
        ));

        return response;
    }
}
