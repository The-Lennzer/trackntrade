package com.tracktrade.trackntrade.controller;

import com.tracktrade.trackntrade.model.MonthlyFund;
import com.tracktrade.trackntrade.model.User;
import com.tracktrade.trackntrade.service.MonthlyFundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MonthlyFundController {

    private final MonthlyFundService monthlyFundService;

    @PostMapping("/add-fund")
    public ResponseEntity<MonthlyFund> addFund(
            @RequestParam UUID userId,
            @RequestParam String month,  // Format: "2025-07"
            @RequestParam(required = false) Double amount
    ) {
        YearMonth ym = YearMonth.parse(month);
        MonthlyFund fund = monthlyFundService.addFund(userId, ym, amount);
        return ResponseEntity.ok(fund);
    }

    @PostMapping("/edit-intake")
    public ResponseEntity<User> updateIntake(
            @RequestParam UUID userId,
            @RequestParam Double newIntake
    ) {
        return ResponseEntity.ok(monthlyFundService.updateMonthlyIntake(userId, newIntake));
    }

    @GetMapping("/funds")
    public ResponseEntity<List<MonthlyFund>> getFunds(@RequestParam UUID userId) {
        return ResponseEntity.ok(monthlyFundService.getAllFunds(userId));
    }
}
