package com.intership.repositories;

import com.intership.models.Contract;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContractRepositoryImpl {

    private final ContractRepository contractRepository;

    public ContractRepositoryImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract getContract(UUID id) {
        Optional<Contract> contractOptional = contractRepository.findById(id);
        if(contractOptional.isPresent()) {
            return contractOptional.get();
        } else {
            throw new NoSuchElementException("Клиент не найден.");
        }
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
