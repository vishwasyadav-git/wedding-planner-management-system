package com.scaler.weddingplanner.mapper;

import com.scaler.weddingplanner.dtos.ClientDTO;
import com.scaler.weddingplanner.models.Client;

public class ClientMapper {
    public static ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getId(), client.getName(), client.getContact(), client.getBudget());
    }

    public static Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setContact(clientDTO.getContact());
        client.setBudget(clientDTO.getBudget());
        return client;
    }
}

