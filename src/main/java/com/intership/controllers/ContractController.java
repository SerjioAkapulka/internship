package com.intership.controllers;

import com.intership.dto.ContractDto;
import com.intership.models.Contract;
import com.intership.services.ContractService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ContractController {

    @Autowired
    ContractService contractService;

    @PostMapping(value = "/contract")
    public Contract saveContract(@RequestBody @Valid ContractDto contractDto) {
        return contractService.save(contractDto);
    }

    @GetMapping("/contract/{id}")
    public Contract getContractById(@PathVariable UUID id) {
        return contractService.getContract(id);
    }
    @DeleteMapping("/contract/{id}")
    public void delete(@PathVariable UUID id) {
        contractService.delete(id);
    }
}
