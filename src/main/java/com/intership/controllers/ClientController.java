package com.intership.controllers;

import com.intership.dto.ClientDto;
import com.intership.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.intership.repositories.ClientRepositoryImpl;
import com.intership.services.ClientService;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/clients", consumes = "application/json", produces = "application/json")
    public Client save(@RequestBody ClientDto clientDto) {
        Client client = new Client(clientDto.getId(), clientDto.getFirstName(), clientDto.getLastName(), clientDto.getBalance());
        return clientService.save(client);
    }
}
