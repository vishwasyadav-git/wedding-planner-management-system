package com.weddingplanner.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {
    private Long id;
    private Long eventId;
    private Long vendorId;
    private String status;

    // Constructors
    public BookingDTO() {}
    public BookingDTO(Long id, Long eventId, Long vendorId, String status) {
        this.id = id;
        this.eventId = eventId;
        this.vendorId = vendorId;
        this.status = status;
    }


}

