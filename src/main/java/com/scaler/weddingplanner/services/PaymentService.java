package com.scaler.weddingplanner.services;

import com.scaler.weddingplanner.models.Payment;
import com.scaler.weddingplanner.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment recordPayment(Payment payment) {
        payment.setPaymentDate(LocalDate.now());
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByClientId(Long clientId) {
        return paymentRepository.findByClientId(clientId);
    }

    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }

    public Double getMonthlyRevenue(int month, int year) {
        return paymentRepository.findMonthlyRevenue(month, year);
    }
}

