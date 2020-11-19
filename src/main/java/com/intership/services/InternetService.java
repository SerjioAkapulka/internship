package com.intership.services;


import com.intership.dto.InternetDto;
import com.intership.exception.BalanceNotEnoughException;
import com.intership.exception.ClientNotFoundException;
import com.intership.exception.ContractNotFoundException;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.models.Internet;
import com.intership.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class InternetService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientRepositoryImpl clientRepositoryImpl;
    @Autowired
    private InternetRepositoryImpl internetRepositoryImpl;
    @Autowired
    private ContractRepositoryImpl contractRepository;


    public Internet save(InternetDto internetDto) {
        Optional<Client> clientOptional = clientRepository.findById(internetDto.getClientId());
        Optional<Contract> contractOptional = Optional.ofNullable(contractRepository.getContractByClientId(internetDto.getClientId()));

        if(!clientOptional.isPresent()) {
            throw new ClientNotFoundException(String.format("Клиент с идентификатором %s не найден.", internetDto.getClientId()));
        }

        if(!contractOptional.isPresent()) {
            throw new ContractNotFoundException(String.format("Контракт клиента с идентификатором %s не найден.", internetDto.getClientId()));
        }


        if (contractOptional.get().getStatus() == Contract.Status.ACTIVE) {
            Internet internet = new Internet();
            internet.setId(internetDto.getId());
            internet.setClient(clientOptional.get());
            internet.setTitle(internetDto.getTitle());
            internet.setCost(internetDto.getCost());

            return internetRepositoryImpl.saveInternet(internet);
        } else {
            throw new ContractNotFoundException(String.format("Контракт клиента с идентификатором %s неактивен или его действие приостановлено", internetDto.getClientId()));
        }
    }

    public Internet getInternet(UUID id) {
        return internetRepositoryImpl.getInternet(id);
    }

    public void delete(UUID id) {
        internetRepositoryImpl.deleteInternet(id);
    }

    public Internet pay(UUID id) {
        Internet internet = internetRepositoryImpl.getInternet(id);
        Client client = internet.getClient();
        int total = client.getBalance() - internet.getCost();
        if (total > 0) {
            client.setBalance(total);
            clientRepositoryImpl.saveClient(client);
            internet.setWasPayed(true);
            internetRepositoryImpl.saveInternet(internet);
            return internet;
        }
        throw new BalanceNotEnoughException("Недостаточно средств для совершения операции");
    }
}
