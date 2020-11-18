package com.intership.controllers;

import com.intership.dto.MobileDto;
import com.intership.models.Mobile;
import com.intership.services.MobileService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class MobileController {
    @Autowired
    MobileService mobileService;

    @PostMapping(value="/mobile")
    public Mobile saveMobile(@ApiParam(value = "save mobile")@RequestBody MobileDto mobileDto) {
        return mobileService.save(mobileDto);
    }

    @DeleteMapping("/mobile/{id}")
    public void delete(@ApiParam(value = "delete mobile")@PathVariable UUID id) {
        mobileService.delete(id);
    }

    @GetMapping("/mobile/{id}")
    public Mobile getMobile(@ApiParam(value = "delete mobile")@PathVariable UUID id) {
        return mobileService.getMobile(id);
    }
}
