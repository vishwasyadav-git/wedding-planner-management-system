package com.weddingplanner.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorDTO {
    private Long id;
    private String name;
    private String serviceType;
    private boolean availability;

    // Constructors
    public VendorDTO() {}
    public VendorDTO(Long id, String name, String serviceType, boolean availability) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.availability = availability;
    }


}

