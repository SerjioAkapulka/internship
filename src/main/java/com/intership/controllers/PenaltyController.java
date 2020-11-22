package com.intership.controllers;

import com.intership.dto.PenaltyDto;
import com.intership.models.Penalty;
import com.intership.services.PenaltyService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class PenaltyController {

    @Autowired
    PenaltyService penaltyService;

    @PostMapping(value = "/penalty")
    public Penalty savePenalty(@RequestBody @Valid PenaltyDto penaltyDto) {
        return penaltyService.save(penaltyDto);
    }

    @DeleteMapping("/penalty/{id}")
    public void delete(@PathVariable UUID id) {
        penaltyService.delete(id);
    }

    @GetMapping("/penalty/{id}")
    public Penalty getPenalty(@PathVariable UUID id) {
        return penaltyService.getPenalty(id);
    }
    @PutMapping(value = "/penalty/pay/{id}")
    public Penalty payPenalty(@PathVariable UUID id) {
        return penaltyService.pay(id);
    }
}
