package com.intership.repositories;

import com.intership.exception.NotFoundException;
import com.intership.models.Mobile;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public class MobileRepo {
    private final MobileRepository mobileRepository;

    public MobileRepo(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    public Mobile getMobile(UUID id) {
        Optional<Mobile> mobileOptional = mobileRepository.findById(id);
        if(mobileOptional.isPresent()) {
            return mobileOptional.get();
        } else {
            throw new NotFoundException("Информация о мобильной связи не найдена.");
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
