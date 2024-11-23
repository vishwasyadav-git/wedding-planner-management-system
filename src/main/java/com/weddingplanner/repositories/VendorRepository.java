package com.weddingplanner.repositories;

import com.weddingplanner.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    // Find vendors by service type
    List<Vendor> findByServiceType(String serviceType);

    // Find available vendors by service type
    @Query("SELECT v FROM Vendor v WHERE v.serviceType = :serviceType AND v.availability = true")
    List<Vendor> findAvailableVendorsByServiceType(@Param("serviceType") String serviceType);

    // Custom query for checking availability on a specific date
    @Query("SELECT v FROM Vendor v WHERE v.availability = true AND :date NOT IN " +
            "(SELECT b.event.date FROM Booking b WHERE b.vendor.id = v.id)")
    List<Vendor> findAvailableVendorsOnDate(@Param("date") LocalDate date);
}

