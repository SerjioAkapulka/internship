package com.intership.repositories;

import com.intership.models.Mobile;

import java.util.Optional;
import java.util.UUID;

public class MoblieRepositoryImpl {
    private final MobileRepository mobileRepository;

    public MoblieRepositoryImpl(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }


}
