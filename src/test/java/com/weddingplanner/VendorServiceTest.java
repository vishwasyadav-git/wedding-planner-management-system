package com.weddingplanner;

import com.weddingplanner.repositories.VendorRepository;
import com.weddingplanner.services.VendorService;
import com.weddingplanner.models.Vendor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VendorServiceTest {

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private VendorService vendorService;

    public VendorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateVendorAvailability() {
        Long vendorId = 2L;
        boolean availability = true;

        // Mock vendor lookup
        Vendor vendor = new Vendor();
        vendor.setId(vendorId);
        vendor.setAvailability(false);

        when(vendorRepository.findById(vendorId)).thenReturn(Optional.of(vendor));
        when(vendorRepository.save(any(Vendor.class))).thenReturn(vendor);

        // Call service method
        vendorService.updateVendorAvailability(vendorId, availability);

        // Verify repository interactions
        verify(vendorRepository).findById(vendorId);
        verify(vendorRepository).save(vendor);
    }

    @Test
    void testUpdateVendorAvailabilityThrowsException() {
        Long vendorId = 2L;
        boolean availability = true;

        // Mock vendor not found
        when(vendorRepository.findById(vendorId)).thenReturn(Optional.empty());

        // Assert exception
        assertThrows(IllegalArgumentException.class,
                () -> vendorService.updateVendorAvailability(vendorId, availability));

        // Verify repository interactions
        verify(vendorRepository).findById(vendorId);
        verifyNoMoreInteractions(vendorRepository);
    }
}

