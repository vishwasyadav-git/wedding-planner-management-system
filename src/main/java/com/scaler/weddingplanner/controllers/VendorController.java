package com.scaler.weddingplanner.controllers;

import com.scaler.weddingplanner.dtos.VendorDTO;
import com.scaler.weddingplanner.mapper.VendorMapper;
import com.scaler.weddingplanner.models.Vendor;
import com.scaler.weddingplanner.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {
    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<VendorDTO> registerVendor(@RequestBody VendorDTO vendorDTO) {
        Vendor vendor = VendorMapper.toEntity(vendorDTO);
        Vendor savedVendor = vendorService.registerVendor(vendor);
        return ResponseEntity.ok(VendorMapper.toDTO(savedVendor));
    }

    @PatchMapping("/{id}/updateAvailability")
    public ResponseEntity<Void> updateVendorAvailability(@PathVariable Long id, @RequestParam boolean availability) {
        vendorService.updateVendorAvailability(id, availability);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/available")
    public List<VendorDTO> getAvailableVendorsByServiceType(@RequestParam String serviceType) {
        return vendorService.getAvailableVendorsByServiceType(serviceType)
                .stream()
                .map(VendorMapper::toDTO)
                .toList();
    }

    @GetMapping("/availability")
    public List<VendorDTO> getAvailableVendorsOnDate(@RequestParam String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return vendorService.getAvailableVendorsOnDate(parsedDate)
                .stream()
                .map(VendorMapper::toDTO)
                .toList();
    }
}

