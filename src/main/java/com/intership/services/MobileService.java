package com.intership.services;

import com.intership.dto.MobileDto;
import com.intership.models.Client;
import com.intership.models.Mobile;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MobileService {
    @Autowired
    private MobileRepository mobileRepository;
    @Autowired
    private ClientRepository clientRepository;

    public MobileService() {

    }

    public Mobile save(MobileDto mobileDto) {
        Optional<Client> clientOptional = clientRepository.findById(mobileDto.getClientId());
       if (clientOptional.isPresent()) {
           Mobile mobile = new Mobile();
           mobile.setClientId(mobileDto.getClientId());
           mobile.setTitle(mobileDto.getTitle());
           mobile.setCost(mobileDto.getCost());
           return mobileRepository.save(mobile);
       } else throw new NoSuchElementException(String.format("Клиент с идентификатором %s не найден" , mobileDto.getClientId()));
    }

}
