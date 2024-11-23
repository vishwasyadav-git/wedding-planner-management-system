package com.scaler.weddingplanner.repositories;

import com.scaler.weddingplanner.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Find payments by client
    List<Payment> findByClientId(Long clientId);

    // Find payments by status (e.g., "Pending", "Completed")
    List<Payment> findByStatus(String status);

    // Find payments within a date range
    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);
   @Query("SELECT SUM(p.amount) FROM Payment p WHERE MONTH(p.paymentDate) = :month AND YEAR(p.paymentDate) = :year")
   Double findMonthlyRevenue(int month, int year);
}

