package com.intership.services;

import com.intership.dto.PenaltyDto;
import com.intership.models.Client;
import com.intership.models.Penalty;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.PenaltyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PenaltyService {

    @Autowired
    private PenaltyRepositoryImpl penaltyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Penalty save (PenaltyDto penaltyDto){
        Optional<Client> clientOptional = clientRepository.findById(penaltyDto.getClientId());
        if (clientOptional.isPresent()) {
            Penalty penalty = new Penalty();
            penalty.setClientId(penaltyDto.getClientId());
            penalty.setTitle(penaltyDto.getTitle());
            penalty.setCost(penaltyDto.getCost());
            return penaltyRepository.savePenalty(penalty);
        } else throw new NoSuchElementException(String.format("Клиент с идентификатором %s не найден" , penaltyDto.getClientId()));
    }


    public Penalty getPenalty(UUID id) {
        return penaltyRepository.getPenalty(id);
    }
    public void delete(UUID id) {
        penaltyRepository.deletePenalty(id);
    }
}
