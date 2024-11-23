package com.weddingplanner.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private Long clientId;
    private double amount;
    private LocalDate paymentDate;
    private String status;

    // Constructors
    public PaymentDTO() {}
    public PaymentDTO(Long id, Long clientId, double amount, LocalDate paymentDate, String status) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }





}

