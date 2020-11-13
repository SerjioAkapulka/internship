package com.intership.services;

import com.intership.dto.InternetDto;
import com.intership.models.Client;
import com.intership.models.Internet;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.InternetRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class InternetService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private InternetRepositoryImpl internetRepository;


    public Internet save(InternetDto internetDto) {
        Optional<Client> clientOptional = clientRepository.findById(internetDto.getClientId());

        if (clientOptional.isPresent()) {
            Internet internet = new Internet();
            internet.setId(internetDto.getId());
            internet.setClientId(internetDto.getClientId());
            internet.setTitle(internetDto.getTitle());
            internet.setInternetCost(internetDto.getCost());

            return internetRepository.saveInternet(internet);
        } else {
            throw new NoSuchElementException(String.format("Клиент с идентификатором %s не найден.", internetDto.getClientId()));
        }
    }

    public Internet getInternet(UUID id) {
        return internetRepository.getInternet(id);
    }

    public void delete(UUID id) {
        internetRepository.deleteInternet(id);
    }
}
