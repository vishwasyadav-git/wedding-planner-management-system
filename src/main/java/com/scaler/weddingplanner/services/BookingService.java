package com.scaler.weddingplanner.services;

import com.scaler.weddingplanner.models.Booking;
import com.scaler.weddingplanner.models.Vendor;
import com.scaler.weddingplanner.repositories.BookingRepository;
import com.scaler.weddingplanner.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final VendorRepository vendorRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, VendorRepository vendorRepository) {
        this.bookingRepository = bookingRepository;
        this.vendorRepository = vendorRepository;
    }

    public Booking createBooking(Booking booking) {
        Vendor vendor = vendorRepository.findById(booking.getVendor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found."));
        if (!vendor.isAvailability()) {
            throw new IllegalArgumentException("Vendor is not available.");
        }
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByEventId(Long eventId) {
        return bookingRepository.findByEventId(eventId);
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found."));
        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
    }
}

