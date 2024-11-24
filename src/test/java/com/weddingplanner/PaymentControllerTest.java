package com.weddingplanner;

import com.weddingplanner.controllers.PaymentController;
import com.weddingplanner.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    public PaymentControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMonthlyRevenue() {
        int month = 11;
        int year = 2024;
        Double expectedRevenue = 5000.0;

        // Mock the service call
        when(paymentService.getMonthlyRevenue(month, year)).thenReturn(expectedRevenue);

        // Call the controller method
        ResponseEntity<Double> response = paymentController.getMonthlyRevenue(month, year);

        // Assert response
        assertEquals(expectedRevenue, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }
}

