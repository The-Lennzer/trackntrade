package com.tracktrade.trackntrade.controller;

import com.tracktrade.trackntrade.model.Expense;
import com.tracktrade.trackntrade.model.RemainingBalance;
import com.tracktrade.trackntrade.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add-expense")
    public ResponseEntity<Expense> addExpense(
            @RequestParam UUID userId,
            @RequestParam Double value,
            @RequestParam String category,
            @RequestParam String color
    ) {
        return ResponseEntity.ok(expenseService.addExpense(userId, value, category, color));
    }

    @PostMapping("/init-balance")
    public ResponseEntity<RemainingBalance> initializeBalance(
            @RequestParam UUID userId,
            @RequestParam String month
    ) {
        return ResponseEntity.ok(
                expenseService.initializeBalance(userId, YearMonth.parse(month))
        );
    }

    @GetMapping("/finance-report")
    public ResponseEntity<Map<String, Object>> getReport(
            @RequestParam UUID userId,
            @RequestParam String month
    ) {
        return ResponseEntity.ok(
                expenseService.getFinanceReport(userId, YearMonth.parse(month))
        );
    }
}
