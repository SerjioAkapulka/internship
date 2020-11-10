package com.intership.repositories;

import com.intership.models.Contract;
import com.intership.models.Internet;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class InternetRepositoryImpl {
    private final InternetRepository internetRepository;

    public InternetRepositoryImpl(InternetRepository internetRepository)  {
        this.internetRepository = internetRepository;
    }
    public Internet getInternet(UUID id) {
        Optional<Internet> internetOptional = internetRepository.findById(id);
        if(internetOptional.isPresent()) {
            return internetOptional.get();
        } else {
            throw new NoSuchElementException("Информация не найдена.");
        }
    }

    public Internet saveInternet(Internet internet) {
        internetRepository.save(internet);
        return internet;
    }

    public void deleteInternet(UUID id) {
        Internet internet = getInternet(id);
        internetRepository.delete(internet);
    }
}
