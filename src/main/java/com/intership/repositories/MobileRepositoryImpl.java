package com.intership.repositories;

import com.intership.models.Mobile;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class MobileRepositoryImpl {
    private final MobileRepository mobileRepository;

    public MobileRepositoryImpl(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    public Mobile getMobile(UUID id) {
        Optional<Mobile> mobileOptional = mobileRepository.findById(id);
        if(mobileOptional.isPresent()) {
            return mobileOptional.get();
        } else {
            throw new NoSuchElementException("Информация о мобильной связи не найдена.");
        }
    }

    public Mobile saveMobile(Mobile mobile) {
        mobileRepository.save(mobile);
        return mobile;
    }

    public void deleteMobile(UUID id) {
        Mobile mobile = getMobile(id);
        mobileRepository.delete(mobile);
    }
}
