package com.intership.repositories;


import com.intership.exception.ContractNotFoundException;
import com.intership.models.Contract;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContractRepositoryImpl {

    private final ContractRepository contractRepository;
    private final ClientRepository clientRepository;

    public ContractRepositoryImpl(ContractRepository contractRepository, ClientRepository clientRepository) {
        this.contractRepository = contractRepository;
        this.clientRepository = clientRepository;
    }

    public Contract getContract(UUID id) {
        Optional<Contract> contractOptional = contractRepository.findById(id);
        if(contractOptional.isPresent()) {
            return contractOptional.get();
        } else {
            throw new NoSuchElementException("Клиент не найден.");
        }
    }

    public Contract getContractByClientId(UUID id) {
        Optional<Contract> contract = contractRepository.findByClientId(id);
        if(contract.isPresent()) {
            return contract.get();
        } else {
            throw new ContractNotFoundException("Клиент не найден.");
        }
        /*for (Contract c : arrayList) {
            if (id.equals(c.getClient().getId())) {
                Optional<Contract> contractOptional = Optional.of(c);
                return contractOptional.get();
            } else {
                throw new NoSuchElementException("Клиент не найден.");
            }
        }
        return null;*/
    }

    public Contract saveContract(Contract contract) {
        contractRepository.save(contract);
        return contract;
    }

    public void deleteContract(UUID id) {
        Contract contract = getContract(id);
        contractRepository.delete(contract);
    }

}
