package com.weddingplanner;

import com.weddingplanner.controllers.VendorController;
import com.weddingplanner.services.VendorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class VendorControllerTest {

    @Mock
    private VendorService vendorService;

    @InjectMocks
    private VendorController vendorController;

    public VendorControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateVendorAvailability() {
        Long vendorId = 2L;
        boolean availability = true;

        // Mock the service call
        doNothing().when(vendorService).updateVendorAvailability(vendorId, availability);

        // Call the controller method
        ResponseEntity<String> response = vendorController.updateVendorAvailability(vendorId, availability);

        // Verify service method is called
        verify(vendorService).updateVendorAvailability(vendorId, availability);

        // Assert response
        assert response.getStatusCode().is2xxSuccessful();
    }
}

