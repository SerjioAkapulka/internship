package com.intership.repositories;


import com.intership.exception.ClientNotFoundException;
import com.intership.exception.ContractNotFoundException;
import com.intership.models.Contract;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContractRepo {

    private final ContractRepository contractRepository;
    //

    public ContractRepo(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract getContract(UUID id) {
        Optional<Contract> contractOptional = contractRepository.findById(id);
        if(contractOptional.isPresent()) {
            return contractOptional.get();
        } else {
            throw new ClientNotFoundException("Клиент не найден.");
        }
    }

    public Contract getContractByClientId(UUID id) {
        Optional<Contract> contract = contractRepository.findByClientId(id);
        if(contract.isPresent()) {
            return contract.get();
        } else {
            throw new ContractNotFoundException("Контракт не найден.");
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
