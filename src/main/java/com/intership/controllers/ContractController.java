package com.intership.controllers;

import com.intership.dto.ContractDto;
import com.intership.models.Contract;
import com.intership.services.ContractService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
public class ContractController {

    @Autowired
    ContractService contractService;

    @PostMapping(value = "/contract")
    public Contract saveContract(@ApiParam(value = "save contract")@RequestBody ContractDto contractDto) {
        return contractService.save(contractDto);
    }

    @GetMapping("/contract/{id}")
    public Contract getContractById(@ApiParam(value = "get contract")@PathVariable UUID id) {
        return contractService.getContract(id);
    }
    @DeleteMapping("/contract/{id}")
    public void delete(@ApiParam(value = "delete contract")@PathVariable UUID id) {
        contractService.delete(id);
    }
}
