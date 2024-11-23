package com.weddingplanner.services;

import com.weddingplanner.models.Vendor;
import com.weddingplanner.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor registerVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    public List<Vendor> getAvailableVendorsByServiceType(String serviceType) {
        return vendorRepository.findAvailableVendorsByServiceType(serviceType);
    }

    public List<Vendor> getAvailableVendorsOnDate(LocalDate date) {
        return vendorRepository.findAvailableVendorsOnDate(date);
    }

    public void updateVendorAvailability(Long id, boolean availability) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found."));
        vendor.setAvailability(availability);
        vendorRepository.save(vendor);
    }
}

