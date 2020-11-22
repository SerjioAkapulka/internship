package com.intership.services;

import com.intership.dto.MobileDto;
import com.intership.exception.*;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.models.Mobile;
import com.intership.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class MobileService {
    @Autowired
    private MobileRepo mobileRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ContractRepo contractRepository;
    @Autowired
    private ClientRepo clientRepo;

    public Mobile save(MobileDto mobileDto) {
        Optional<Client> clientOptional = clientRepository.findById(mobileDto.getClientId());
        Optional<Contract> contractOptional = Optional.ofNullable(contractRepository.getContractByClientId(mobileDto.getClientId()));

        if(!clientOptional.isPresent()) {
            throw new ClientNotFoundException(String.format("Клиент с идентификатором %s не найден.", mobileDto.getClientId()));
        }

        if(!contractOptional.isPresent()) {
            throw new ContractNotFoundException(String.format("Контракт клиента с идентификатором %s не найден.", mobileDto.getClientId()));
        }

        if (contractOptional.get().getStatus() == Contract.Status.ACTIVE) {
            Mobile mobile = new Mobile();
            mobile.setId(mobileDto.getId());
            mobile.setClient(clientOptional.get());
            mobile.setTitle(mobileDto.getTitle());
            mobile.setCost(mobileDto.getCost());

            return mobileRepository.saveMobile(mobile);
        } else {
            throw new ContractNotFoundException(String.format("Контракт клиента с идентификатором %s неактивен  или его действие приостановлено", mobileDto.getClientId()));
        }
    }
    public Mobile pay(UUID id) {
        Mobile mobile = mobileRepository.getMobile(id);
        if (mobile.isWasPayed()) {
            throw new CommonException("Мобильный тариф уже оплачен");
        }
        Client client = mobile.getClient();
        int total = client.getBalance() - mobile.getCost();
        if (total > 0) {
            client.setBalance(total);
            clientRepo.saveClient(client);
            mobile.setWasPayed(true);
            mobileRepository.saveMobile(mobile);
            return mobile;
        }
        throw new BalanceNotEnoughException("Недостаточно средств для совершения операции");
    }


    public Mobile getMobile(UUID id) {
        return mobileRepository.getMobile(id);
    }
    public void delete(UUID id) {
        mobileRepository.deleteMobile(id);
    }

}
