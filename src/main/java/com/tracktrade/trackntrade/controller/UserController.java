package com.tracktrade.trackntrade.controller;

import com.tracktrade.trackntrade.model.User;
import com.tracktrade.trackntrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam UUID userId) {
        return userService.getUser(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/delete-account")
    public ResponseEntity<Void> delete(@RequestParam UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
