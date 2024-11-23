package com.scaler.weddingplanner.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class EventDTO {
    private Long id;
    private String type;
    private LocalDate date;
    private Long clientId;

    // Constructors
    public EventDTO() {}
    public EventDTO(Long id, String type, LocalDate date, Long clientId) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.clientId = clientId;
    }


}

