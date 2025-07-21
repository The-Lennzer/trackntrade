package com.tracktrade.trackntrade.controller;

import com.tracktrade.trackntrade.model.Liability;
import com.tracktrade.trackntrade.service.LiabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LiabilityController {

    private final LiabilityService liabilityService;

    @PostMapping("/create-liability")
    public ResponseEntity<Liability> createLiability(
            @RequestParam UUID userId,
            @RequestParam String name,
            @RequestParam Double value
    ) {
        return ResponseEntity.ok(liabilityService.createLiability(userId, name, value));
    }

    @PostMapping("/edit-liability")
    public ResponseEntity<Liability> editLiability(
            @RequestParam UUID id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double value
    ) {
        return ResponseEntity.ok(liabilityService.editLiability(id, name, value));
    }

    @DeleteMapping("/delete-liability")
    public ResponseEntity<Void> deleteLiability(@RequestParam UUID id) {
        liabilityService.deleteLiability(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/liabilities")
    public ResponseEntity<List<Liability>> getLiabilities(@RequestParam UUID userId) {
        return ResponseEntity.ok(liabilityService.getAllByUser(userId));
    }
}
