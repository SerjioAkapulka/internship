package com.intership.controllers;

import com.intership.dto.PenaltyDto;
import com.intership.models.Mobile;
import com.intership.models.Penalty;
import com.intership.services.PenaltyService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PenaltyController {

    @Autowired
    PenaltyService penaltyService;

    @PostMapping(value = "/penalty")
    public Penalty savePenalty(@ApiParam(value = "save penalty")@RequestBody PenaltyDto penaltyDto) {
        return penaltyService.save(penaltyDto);
    }

    @DeleteMapping("/penalty/{id}")
    public void delete(@ApiParam(value = "delete penalty")@PathVariable UUID id) {
        penaltyService.delete(id);
    }

    @GetMapping("/penalty/{id}")
    public Penalty getPenalty(@ApiParam(value = "get penalty")@PathVariable UUID id) {
        return penaltyService.getPenalty(id);
    }
    @PutMapping(value = "/penalty/pay/{id}")
    public Penalty payPenalty(@ApiParam(value = "pay penalty")@PathVariable UUID id) {
        return penaltyService.pay(id);
    }
}
