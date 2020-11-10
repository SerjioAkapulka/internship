package com.intership.services;

import com.intership.dto.PenaltyDto;
import com.intership.models.Client;
import com.intership.models.Penalty;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.PenaltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PenaltyService {

    @Autowired
    private PenaltyRepository penaltyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public PenaltyService() {

    }

    public Penalty save (PenaltyDto penaltyDto){
        Optional<Client> clientOptional = clientRepository.findById(penaltyDto.getClientId());
        if (clientOptional.isPresent()) {
            Penalty penalty = new Penalty();
            penalty.setClientId(penaltyDto.getClientId());
            penalty.setTitle(penaltyDto.getTitle());
            penalty.setCost(penaltyDto.getCost());
            return penaltyRepository.save(penalty);
        } else throw new NoSuchElementException(String.format("Клиент с идентификатором %s не найден" , penaltyDto.getClientId()));
    }


}
