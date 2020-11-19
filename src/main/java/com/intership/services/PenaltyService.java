package com.intership.services;

import com.intership.dto.PenaltyDto;
import com.intership.exception.BalanceNotEnoughException;
import com.intership.exception.ClientNotFoundException;
import com.intership.exception.ContractNotFoundException;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.models.Penalty;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.ClientRepositoryImpl;
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
    @Autowired
    private ClientRepositoryImpl clientRepositoryImpl;

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
        Client client = penalty.getClient();
        int total = client.getBalance() - penalty.getCost();
        if (total > 0) {
            client.setBalance(total);
            clientRepositoryImpl.saveClient(client);
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
