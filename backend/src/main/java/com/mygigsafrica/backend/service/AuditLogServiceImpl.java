package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.AuditLog;
import com.mygigsafrica.backend.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public AuditLog createLog(AuditLog log) {
        return auditLogRepository.save(log);
    }

    @Override
    public List<AuditLog> getLogsByUserId(Long userId) {
        return auditLogRepository.findByUserId(userId);
    }

    @Override
    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }
}

