package com.intership.controllers;

import com.intership.dto.ContractDto;
import com.intership.dto.InternetDto;
import com.intership.models.Contract;
import com.intership.models.Internet;
import com.intership.services.ContractService;
import com.intership.services.InternetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class InternetController {

    @Autowired
    InternetService internetService;

    @PostMapping(value = "/internet/save")
    public Internet saveInternet(@RequestBody InternetDto internetDto) {
        return internetService.save(internetDto);
    }

    @GetMapping("/internet/get/{id}")
    public Internet getInternet(@PathVariable UUID id) {
        return internetService.getInternet(id);
    }
}
