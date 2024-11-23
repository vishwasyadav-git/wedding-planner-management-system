package com.weddingplanner.mapper;

import com.weddingplanner.dtos.VendorDTO;
import com.weddingplanner.models.Vendor;

public class VendorMapper {

    // Convert Entity to DTO
    public static VendorDTO toDTO(Vendor vendor) {
        return new VendorDTO(
                vendor.getId(),
                vendor.getName(),
                vendor.getServiceType(),
                vendor.isAvailability()
        );
    }

    // Convert DTO to Entity
    public static Vendor toEntity(VendorDTO vendorDTO) {
        Vendor vendor = new Vendor();
        vendor.setId(vendorDTO.getId());
        vendor.setName(vendorDTO.getName());
        vendor.setServiceType(vendorDTO.getServiceType());
        vendor.setAvailability(vendorDTO.isAvailability());
        return vendor;
    }
}

