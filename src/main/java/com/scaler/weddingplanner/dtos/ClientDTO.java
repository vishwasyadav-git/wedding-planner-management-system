package com.scaler.weddingplanner.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String name;
    private String contact;
    private double budget;

    // Constructors
    public ClientDTO() {}
    public ClientDTO(Long id, String name, String contact, double budget) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.budget = budget;
    }


}

