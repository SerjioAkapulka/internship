package com.intership.repositories;


import com.intership.exception.ClientNotFoundException;
import com.intership.models.Client;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientRepo {

    private final ClientRepository clientRepository;

    public ClientRepo(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    public Client getClient(UUID id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()) {
            return clientOptional.get();
        } else {
            throw new ClientNotFoundException("Клиент не найден.");
        }
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public void deleteAllClients() {
        clientRepository.deleteAll();
    }


    public void deleteClient(UUID clientId) {
        Client client = getClient(clientId);
        clientRepository.delete(client);
    }

    public long count() {
        return clientRepository.count();
    }

}
