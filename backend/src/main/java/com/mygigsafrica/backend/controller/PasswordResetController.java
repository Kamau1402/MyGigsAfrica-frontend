package com.mygigsafrica.backend.controller;

import com.mygigsafrica.backend.entity.PasswordReset;
import com.mygigsafrica.backend.service.PasswordResetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/password-resets")
public class PasswordResetController {
    private final PasswordResetService passwordResetService;

    public PasswordResetController(PasswordResetService passwordResetService) {
        this.passwordResetService = passwordResetService;
    }

    @PostMapping
    public ResponseEntity<PasswordReset> createOrUpdateReset(@RequestBody PasswordReset reset) {
        PasswordReset saved = passwordResetService.createOrUpdateReset(reset);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<PasswordReset> getByToken(@PathVariable String token) {
        Optional<PasswordReset> result = passwordResetService.getByToken(token);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<PasswordReset> getByUserId(@PathVariable Long userId) {
        Optional<PasswordReset> result = passwordResetService.getByUserId(userId);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteByUserId(@PathVariable Long userId) {
        passwordResetService.deleteByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}

