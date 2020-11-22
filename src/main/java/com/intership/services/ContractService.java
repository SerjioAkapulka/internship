package com.intership.services;

import com.intership.dto.ContractDto;
import com.intership.exception.ClientNotFoundException;
import com.intership.exception.CommonException;
import com.intership.models.Client;
import com.intership.models.Contract;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.ContractRepository;
import com.intership.repositories.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ContractRepo contractRepo;
    @Autowired
    private ContractRepository contractRepository;

    public ContractService(ContractRepo contractRepository) {
        this.contractRepo = contractRepository;
    }

    public Contract save(ContractDto contractDto) {
        Optional<Contract> contractOptional = contractRepository.findByIdAndClientId(contractDto.getId(), contractDto.getClientId());
        Contract contract;


        if (contractOptional.isPresent()) {
            contract = contractOptional.get();

            contract.setStatus(contractDto.getStatus());
            return contractRepository.save(contract);
        } else {
            if(contractRepository.findById(contractDto.getId()).isPresent()) {
                throw new CommonException("Запись с таким идентификатором контракта уже существует.");
            }
            contract = new Contract();
            Client client = clientRepository.findById(contractDto.getClientId())
                    .orElseThrow(() -> new ClientNotFoundException("Клиент с данным идентификатором не найден."));
            contract.setId(contractDto.getId());
            contract.setClient(client);
            contract.setStatus(contractDto.getStatus());
            contract.setDateTimeOfConcludeContract(new Date());

            return contractRepository.save(contract);
        }
    }

    public Contract getContract(UUID id) {
        return contractRepo.getContract(id);
    }

    public void delete(UUID id) {
        contractRepo.deleteContract(id);
    }
}
