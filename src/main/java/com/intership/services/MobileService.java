package com.intership.services;

import com.intership.dto.MobileDto;
import com.intership.exception.BalanceNotEnoughException;
import com.intership.exception.ClientNotFoundException;
import com.intership.exception.ContractNotFoundException;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.models.Mobile;
import com.intership.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MobileService {
    @Autowired
    private MobileRepositoryImpl mobileRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ContractRepositoryImpl contractRepository;
    @Autowired
    private ClientRepositoryImpl clientRepositoryImpl;

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
        Client client = mobile.getClient();
        int total = client.getBalance() - mobile.getCost();
        if (total > 0) {
            client.setBalance(total);
            clientRepositoryImpl.saveClient(client);
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
