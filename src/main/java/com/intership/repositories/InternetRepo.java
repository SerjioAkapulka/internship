package com.intership.repositories;

import com.intership.exception.NotFoundException;
import com.intership.models.Internet;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class InternetRepo {
    private final InternetRepository internetRepository;

    public InternetRepo(InternetRepository internetRepository)  {
        this.internetRepository = internetRepository;
    }
    public Internet getInternet(UUID id) {
        Optional<Internet> internetOptional = internetRepository.findById(id);
        if(internetOptional.isPresent()) {
            return internetOptional.get();
        } else {
            throw new NotFoundException("Информация об интернет тарифе не найдена.");
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
