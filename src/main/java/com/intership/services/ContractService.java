package com.intership.services;

import com.intership.dto.ContractDto;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.ContractRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContractRepositoryImpl contractRepositoryImpl;

    public ContractService(ContractRepositoryImpl contractRepository) {
        this.contractRepositoryImpl = contractRepository;
    }


    public Contract save(ContractDto contractDto) {
        Optional<Client> clientOptional = clientRepository.findById(contractDto.getClientId());

        if(clientOptional.isPresent()) {
            Contract contract = new Contract();
            contract.setClient(clientOptional.get());
            contract.setId(contractDto.getId());
            contract.setStatus(contractDto.getStatus());

            return contractRepositoryImpl.saveContract(contract);
        } else {
            throw new NoSuchElementException(String.format("Клиент с идентификатором %s не найден.", contractDto.getClientId()));
        }
    }
    public Contract getContract(UUID id) {
        return contractRepositoryImpl.getContract(id);
    }

    public void delete(UUID id) {
        contractRepositoryImpl.deleteContract(id);
    }
}
