package com.weddingplanner.mapper;

import com.weddingplanner.dtos.BookingDTO;
import com.weddingplanner.models.Booking;
import com.weddingplanner.models.Event;
import com.weddingplanner.models.Vendor;

public class BookingMapper {

    // Convert Entity to DTO
    public static BookingDTO toDTO(Booking booking) {
        return new BookingDTO(
                booking.getId(),
                booking.getEvent().getId(),
                booking.getVendor().getId(),
                booking.getStatus()
        );
    }

    // Convert DTO to Entity
    public static Booking toEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();

        // Event reference
        Event event = new Event();
        event.setId(bookingDTO.getEventId());
        booking.setEvent(event);

        // Vendor reference
        Vendor vendor = new Vendor();
        vendor.setId(bookingDTO.getVendorId());
        booking.setVendor(vendor);

        booking.setStatus(bookingDTO.getStatus());
        return booking;
    }
}

