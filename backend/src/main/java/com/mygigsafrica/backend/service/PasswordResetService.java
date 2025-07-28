package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.PasswordReset;
import java.util.Optional;

public interface PasswordResetService {
    PasswordReset createOrUpdateReset(PasswordReset reset);
    Optional<PasswordReset> getByToken(String token);
    Optional<PasswordReset> getByUserId(Long userId);
    void deleteByUserId(Long userId);
}

