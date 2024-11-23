package com.scaler.weddingplanner.mapper;

import com.scaler.weddingplanner.dtos.PaymentDTO;
import com.scaler.weddingplanner.models.Client;
import com.scaler.weddingplanner.models.Payment;

public class PaymentMapper {

    // Convert Entity to DTO
    public static PaymentDTO toDTO(Payment payment) {
        return new PaymentDTO(
                payment.getId(),
                payment.getClient().getId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getStatus()
        );
    }

    // Convert DTO to Entity
    public static Payment toEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setStatus(paymentDTO.getStatus());

        // Client reference
        Client client = new Client();
        client.setId(paymentDTO.getClientId());
        payment.setClient(client);

        return payment;
    }
}

