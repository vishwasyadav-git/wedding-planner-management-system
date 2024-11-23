package com.weddingplanner.repositories;
import com.weddingplanner.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Find bookings by event
    List<Booking> findByEventId(Long eventId);

    // Find bookings by vendor
    List<Booking> findByVendorId(Long vendorId);

    // Find bookings by status (e.g., "Cancelled", "Booked")
    List<Booking> findByStatus(String status);
}

