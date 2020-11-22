package com.intership.services;

import com.intership.dto.PenaltyDto;
import com.intership.exception.*;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.models.Penalty;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.ClientRepo;
import com.intership.repositories.ContractRepo;
import com.intership.repositories.PenaltyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class PenaltyService {

    @Autowired
    private PenaltyRepo penaltyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContractRepo contractRepository;
    @Autowired
    private ClientRepo clientRepo;

    public Penalty save (PenaltyDto penaltyDto){
        Optional<Client> clientOptional = clientRepository.findById(penaltyDto.getClientId());
        Optional<Contract> contractOptional = Optional.ofNullable(contractRepository.getContractByClientId(penaltyDto.getClientId()));

        if(!clientOptional.isPresent()) {
            throw new ClientNotFoundException(String.format("Клиент с идентификатором %s не найден.", penaltyDto.getClientId()));
        }

        if(!contractOptional.isPresent()) {
            throw new ContractNotFoundException(String.format("Контракт клиента с идентификатором %s не найден.", penaltyDto.getClientId()));
        }
        if (contractOptional.get().getStatus()== Contract.Status.ACTIVE) {
            Penalty penalty = new Penalty();
            penalty.setId(penaltyDto.getId());
            penalty.setClient(clientOptional.get());
            penalty.setTitle(penaltyDto.getTitle());
            penalty.setCost(penaltyDto.getCost());

            return penaltyRepository.savePenalty(penalty);
        } else {
            throw new ContractNotFoundException(String.format("Контракт клиента с идентификатором %s неактивен или его действие приостановлено", penaltyDto.getClientId()));
        }
    }
    public Penalty pay(UUID id) {
        Penalty penalty = penaltyRepository.getPenalty(id);
        if (penalty.isWasPayed()) {
            throw new CommonException("Штраф уже оплачен");
        }
        Client client = penalty.getClient();
        int total = client.getBalance() - penalty.getCost();
        if (total > 0) {
            client.setBalance(total);
            clientRepo.saveClient(client);
            penalty.setWasPayed(true);
            penaltyRepository.savePenalty(penalty);
            return penalty;
        }
        throw new BalanceNotEnoughException("Недостаточно средств для совершения операции");
    }


    public Penalty getPenalty(UUID id) {
        return penaltyRepository.getPenalty(id);
    }
    public void delete(UUID id) {
        penaltyRepository.deletePenalty(id);
    }
}
