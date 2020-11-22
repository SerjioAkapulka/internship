package com.intership.services;


import com.intership.dto.InternetDto;
import com.intership.exception.*;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.models.Internet;
import com.intership.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class InternetService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private InternetRepo internetRepo;
    @Autowired
    private ContractRepo contractRepository;


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

            return internetRepo.saveInternet(internet);
        } else {
            throw new ContractNotFoundException(String.format("Контракт клиента с идентификатором %s неактивен или его действие приостановлено", internetDto.getClientId()));
        }
    }

    public Internet getInternet(UUID id) {
        return internetRepo.getInternet(id);
    }

    public void delete(UUID id) {
        internetRepo.deleteInternet(id);
    }

    public Internet pay(UUID id) {
        Internet internet = internetRepo.getInternet(id);
        if (internet.isWasPayed()) {
            throw new CommonException("Интернет тариф уже оплачен");
        }
        Client client = internet.getClient();
        int total = client.getBalance() - internet.getCost();
        if (total > 0) {
            client.setBalance(total);
            clientRepo.saveClient(client);
            internet.setWasPayed(true);
            internetRepo.saveInternet(internet);
            return internet;
        }
        throw new BalanceNotEnoughException("Недостаточно средств для совершения операции");
    }
}
