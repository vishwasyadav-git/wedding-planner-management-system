package com.scaler.weddingplanner.controllers;

import com.scaler.weddingplanner.dtos.PaymentDTO;
import com.scaler.weddingplanner.mapper.PaymentMapper;
import com.scaler.weddingplanner.models.Payment;
import com.scaler.weddingplanner.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> recordPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = PaymentMapper.toEntity(paymentDTO);
        Payment savedPayment = paymentService.recordPayment(payment);
        return ResponseEntity.ok(PaymentMapper.toDTO(savedPayment));
    }

    @GetMapping
    public List<PaymentDTO> getPaymentsByStatus(@RequestParam(required = false) String status) {
        if (status != null) {
            return paymentService.getPaymentsByStatus(status)
                    .stream()
                    .map(PaymentMapper::toDTO)
                    .toList();
        }
        return paymentService.getPaymentsByStatus("Completed")
                .stream()
                .map(PaymentMapper::toDTO)
                .toList();
    }
    @GetMapping("/monthly-revenue")
    public ResponseEntity<Double> getMonthlyRevenue(@RequestParam int month, @RequestParam int year) {
        Double revenue = paymentService.getMonthlyRevenue(month, year);
        return ResponseEntity.ok(revenue);
    }
}

