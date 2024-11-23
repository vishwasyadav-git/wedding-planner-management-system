package com.scaler.weddingplanner.repositories;

import com.scaler.weddingplanner.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}
