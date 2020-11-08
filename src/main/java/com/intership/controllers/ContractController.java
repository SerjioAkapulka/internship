package com.intership.controllers;

import com.intership.dto.ContractDto;
import com.intership.models.Contract;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "contract")
public class ContractController {

    @PostMapping
    public Contract saveContract(@RequestBody ContractDto contractDto) {
        return null;
    }
}
