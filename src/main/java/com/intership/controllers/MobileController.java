package com.intership.controllers;

import com.intership.dto.MobileDto;
import com.intership.models.Mobile;
import com.intership.services.MobileService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class MobileController {
    @Autowired
    MobileService mobileService;

    @PostMapping(value="/mobile")
    public Mobile saveMobile(@RequestBody @Valid MobileDto mobileDto) {
        return mobileService.save(mobileDto);
    }

    @DeleteMapping("/mobile/{id}")
    public void delete(@PathVariable UUID id) {
        mobileService.delete(id);
    }

    @GetMapping("/mobile/{id}")
    public Mobile getMobile(@PathVariable UUID id) {
        return mobileService.getMobile(id);
    }

    @PutMapping(value = "/mobile/pay/{id}")
    public Mobile payMobile(@PathVariable UUID id) {
        return mobileService.pay(id);
    }
}
