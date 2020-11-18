package com.intership.controllers;



import com.intership.dto.InternetDto;
import com.intership.models.Internet;
import com.intership.services.InternetService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class InternetController {

    @Autowired
    InternetService internetService;

    @PostMapping(value = "/internet")
    public Internet saveInternet(@ApiParam(value = "save internet")@RequestBody InternetDto internetDto) {
        return internetService.save(internetDto);
    }

    @GetMapping("/internet/{id}")
    public Internet getInternet(@ApiParam(value = "get internet")@PathVariable UUID id) {
        return internetService.getInternet(id);
    }

    @PutMapping(value = "/internet/pay/{id}")
    public Internet payInternet(@ApiParam(value = "pay internet")@PathVariable UUID id) {
        return internetService.pay(id);
    }

    @DeleteMapping("/internet/{id}")
    public void delete(@ApiParam(value = "delete internet")@PathVariable UUID id) {
        internetService.delete(id);
    }
}
