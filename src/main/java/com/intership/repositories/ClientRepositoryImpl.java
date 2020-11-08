package com.intership.repositories;


import com.intership.models.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl {

    private final ClientRepository clientRepository;

    public ClientRepositoryImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        clientRepository.save(client);
        return client;
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }


    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public long count() {
        return clientRepository.count();
    }

}
