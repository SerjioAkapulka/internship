package com.intership.controllers;

import com.intership.dto.ClientDto;
import com.intership.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.intership.services.ClientService;

import java.util.UUID;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/clients", consumes = "application/json", produces = "application/json")
    public Client save(@RequestBody ClientDto clientDto) {
        Client client = new Client(clientDto.getId(), clientDto.getFirstName(), clientDto.getLastName(), clientDto.getBalance());
        return clientService.save(client);
    }

    //На вход clientId -> MobileRepository.findByClientId(), PenaltyRepository.findByClientId(), InternetRepository.findByClientId() -> Передаёшь в дто

    @GetMapping("/clients/{clientId}")
    public Client getClientById(@PathVariable UUID clientId) {
        return clientService.getClient(clientId);
    }


    @DeleteMapping("/clients")
    public void deleteAll() {
        clientService.deleteAll();
    }

    @DeleteMapping("/client/{clientId}")
    public void delete(@PathVariable UUID clientId) {
        clientService.delete(clientId);
    }
}
