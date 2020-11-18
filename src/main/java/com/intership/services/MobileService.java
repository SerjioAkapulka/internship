package com.intership.services;

import com.intership.dto.MobileDto;
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

    public Mobile save(MobileDto mobileDto) {
        Optional<Client> clientOptional = clientRepository.findById(mobileDto.getClientId());
        Optional<Contract> contractOptional = Optional.ofNullable(contractRepository.getContractByClientId(mobileDto.getClientId()));

        if (clientOptional.isPresent() && contractOptional.isPresent() && contractOptional.get().getStatus().equals("Active")) {
            Mobile mobile = new Mobile();
            mobile.setId(mobileDto.getId());
            mobile.setClient(clientOptional.get());
            mobile.setTitle(mobileDto.getTitle());
            mobile.setCost(mobileDto.getCost());

            return mobileRepository.saveMobile(mobile);
        } else {
            throw new ContractNotFoundException(String.format("Клиент (или контракт клиента) с идентификатором %s не найден.", mobileDto.getClientId()));
        }
    }


    public Mobile getMobile(UUID id) {
        return mobileRepository.getMobile(id);
    }
    public void delete(UUID id) {
        mobileRepository.deleteMobile(id);
    }

}
