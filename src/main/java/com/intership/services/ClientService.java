package com.intership.services;

import com.intership.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intership.repositories.ClientRepo;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private final ClientRepo clientRepository;

    public ClientService(ClientRepo clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.saveClient(client);
    }

    public Client getClient(UUID id) {
        return clientRepository.getClient(id);
    }

    public void deleteAll() {
        clientRepository.deleteAllClients();
    }

    public void delete(UUID clientId) {
        clientRepository.deleteClient(clientId);
    }



}

