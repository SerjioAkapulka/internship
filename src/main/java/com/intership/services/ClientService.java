package com.intership.services;


import com.intership.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intership.repositories.ClientRepositoryImpl;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private final ClientRepositoryImpl clientRepository;

    public ClientService(ClientRepositoryImpl clientRepository) {
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

