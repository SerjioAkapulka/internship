package com.intership.controllers;

import com.intership.dto.PenaltyDto;
import com.intership.models.Penalty;
import com.intership.services.PenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PenaltyController {

    @Autowired
    PenaltyService penaltyService;

    @PostMapping(value = "/penalty/save")
    public Penalty savePenalty(@RequestBody PenaltyDto penaltyDto) {
        return penaltyService.save(penaltyDto);
    }

    @DeleteMapping("/penalty/{id}")
    public void delete(@PathVariable UUID id) {
        penaltyService.delete(id);
    }

    @GetMapping("/penalty/get/{id}")
    public Penalty getPenalty(@PathVariable UUID id) {
        return penaltyService.getPenalty(id);
    }
}
