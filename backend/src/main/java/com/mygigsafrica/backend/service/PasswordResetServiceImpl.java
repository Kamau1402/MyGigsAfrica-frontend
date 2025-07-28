package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.PasswordReset;
import com.mygigsafrica.backend.repository.PasswordResetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {
    @Autowired
    private PasswordResetRepository passwordResetRepository;

    @Override
    public PasswordReset createOrUpdateReset(PasswordReset reset) {
        return passwordResetRepository.save(reset);
    }

    @Override
    public Optional<PasswordReset> getByToken(String token) {
        return passwordResetRepository.findByToken(token);
    }

    @Override
    public Optional<PasswordReset> getByUserId(Long userId) {
        return passwordResetRepository.findByUserId(userId);
    }

    @Override
    public void deleteByUserId(Long userId) {
        passwordResetRepository.deleteById(userId);
    }
}

