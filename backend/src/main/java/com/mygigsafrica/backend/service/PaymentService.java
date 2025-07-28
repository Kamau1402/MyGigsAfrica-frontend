package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createOrUpdatePayment(Payment payment);
    Optional<Payment> getPaymentById(Long id);
    List<Payment> getPaymentsByUserId(Long userId);
    void deletePayment(Long id);
}

