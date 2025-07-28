package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.AuditLog;
import java.util.List;

public interface AuditLogService {
    AuditLog createLog(AuditLog log);
    List<AuditLog> getLogsByUserId(Long userId);
    List<AuditLog> getAllLogs();
}

