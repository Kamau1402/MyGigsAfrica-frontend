package com.mygigsafrica.backend.controller;

import com.mygigsafrica.backend.entity.AuditLog;
import com.mygigsafrica.backend.service.AuditLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {
    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<AuditLog> createLog(@RequestBody AuditLog log) {
        AuditLog savedLog = auditLogService.createLog(log);
        return ResponseEntity.ok(savedLog);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLog>> getLogsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(auditLogService.getLogsByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllLogs() {
        return ResponseEntity.ok(auditLogService.getAllLogs());
    }
}

