package com.intership.controllers;

import com.intership.dto.MobileDto;
import com.intership.models.Mobile;
import com.intership.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class MobileController {
    @Autowired
    MobileService mobileService;

    @PostMapping(value="/mobile/save")
    public Mobile saveMobile(@RequestBody MobileDto mobileDto) {
        return mobileService.save(mobileDto);
    }

    @DeleteMapping("/mobile/{id}")
    public void delete(@PathVariable UUID id) {
        mobileService.delete(id);
    }

    @GetMapping("/mobile/get/{id}")
    public Mobile getMobile(@PathVariable UUID id) {
        return mobileService.getMobile(id);
    }
}
