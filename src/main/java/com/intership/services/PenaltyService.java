package com.intership.services;

import com.intership.dto.PenaltyDto;
import com.intership.exception.ContractNotFoundException;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.models.Penalty;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.ContractRepositoryImpl;
import com.intership.repositories.PenaltyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class PenaltyService {

    @Autowired
    private PenaltyRepositoryImpl penaltyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContractRepositoryImpl contractRepository;

    public Penalty save (PenaltyDto penaltyDto){
        Optional<Client> clientOptional = clientRepository.findById(penaltyDto.getClientId());
        Optional<Contract> contractOptional = Optional.ofNullable(contractRepository.getContractByClientId(penaltyDto.getClientId()));

        if (clientOptional.isPresent() && contractOptional.isPresent() && contractOptional.get().getStatus().equals("Active")) {
            Penalty penalty = new Penalty();
            penalty.setId(penaltyDto.getId());
            penalty.setClient(clientOptional.get());
            penalty.setTitle(penaltyDto.getTitle());
            penalty.setCost(penaltyDto.getCost());

            return penaltyRepository.savePenalty(penalty);
        } else {
            throw new ContractNotFoundException(String.format("Клиент (или контракт клиента) с идентификатором %s не найден.", penaltyDto.getClientId()));
        }
    }


    public Penalty getPenalty(UUID id) {
        return penaltyRepository.getPenalty(id);
    }
    public void delete(UUID id) {
        penaltyRepository.deletePenalty(id);
    }
}
