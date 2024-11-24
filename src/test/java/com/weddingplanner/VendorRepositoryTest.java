package com.weddingplanner;

import com.weddingplanner.models.Vendor;
import com.weddingplanner.repositories.VendorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VendorRepositoryTest {

    @Autowired
    private VendorRepository vendorRepository;

    @Test
    void testFindAvailableVendorsByServiceType() {
        // Arrange
        Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor 1");
        vendor1.setServiceType("Catering");
        vendor1.setAvailability(true);
        vendorRepository.save(vendor1);

        Vendor vendor2 = new Vendor();
        vendor2.setName("Vendor 2");
        vendor2.setServiceType("Photography");
        vendor2.setAvailability(false);
        vendorRepository.save(vendor2);

        // Act
        List<Vendor> availableVendors = vendorRepository.findAvailableVendorsByServiceType("Catering");

        // Assert
        assertEquals(1, availableVendors.size());
        assertEquals("Vendor 1", availableVendors.get(0).getName());
    }
}

