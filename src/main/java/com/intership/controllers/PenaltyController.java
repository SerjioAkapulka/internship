package com.intership.controllers;

import com.intership.dto.PenaltyDto;
import com.intership.models.Penalty;
import com.intership.services.PenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PenaltyController {

    @Autowired
    PenaltyService penaltyService;

    @PostMapping(value = "/penalty/save")
    public Penalty savePenalty(@RequestBody PenaltyDto penaltyDto) {
        return penaltyService.save(penaltyDto);
    }
}
