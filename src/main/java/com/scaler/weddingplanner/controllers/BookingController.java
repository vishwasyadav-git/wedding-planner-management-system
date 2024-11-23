package com.scaler.weddingplanner.controllers;

import com.scaler.weddingplanner.dtos.BookingDTO;
import com.scaler.weddingplanner.mapper.BookingMapper;
import com.scaler.weddingplanner.models.Booking;
import com.scaler.weddingplanner.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = BookingMapper.toEntity(bookingDTO);
        Booking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(BookingMapper.toDTO(savedBooking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(booking -> ResponseEntity.ok(BookingMapper.toDTO(booking)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }
}

