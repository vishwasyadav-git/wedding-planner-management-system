package com.weddingplanner.controllers;

import com.weddingplanner.dtos.ClientDTO;
import com.weddingplanner.mapper.ClientMapper;
import com.weddingplanner.models.Client;
import com.weddingplanner.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> registerClient(@RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        Client savedClient = clientService.registerClient(client);
        return ResponseEntity.ok(ClientMapper.toDTO(savedClient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(client -> ResponseEntity.ok(ClientMapper.toDTO(client)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients()
                .stream()
                .map(ClientMapper::toDTO)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}

