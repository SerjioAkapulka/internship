package com.intership.controllers;

import com.intership.dto.MobileDto;
import com.intership.models.Mobile;
import com.intership.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController {
    @Autowired
    MobileService mobileService;

    @PostMapping(value="/mobile/save")
    public Mobile saveMobile(@RequestBody MobileDto mobileDto) {
        return mobileService.save(mobileDto);
    }
}
