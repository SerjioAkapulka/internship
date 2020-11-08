package com.intership.services;


import com.intership.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intership.repositories.ClientRepositoryImpl;

@Service
public class ClientService {

    @Autowired
    private ClientRepositoryImpl clientRepository;

    public ClientService(ClientRepositoryImpl clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }


    public Iterable findAll() {
        return clientRepository.findAll();
    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }

    public long count() {
        return clientRepository.count();
    }
}

