package com.intership.services;

import com.intership.dto.MobileDto;
import com.intership.models.Client;
import com.intership.models.Mobile;
import com.intership.repositories.ClientRepository;
import com.intership.repositories.MobileRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MobileService {
    @Autowired
    private MobileRepositoryImpl mobileRepository;
    @Autowired
    private ClientRepository clientRepository;

    public Mobile save(MobileDto mobileDto) {
        Optional<Client> clientOptional = clientRepository.findById(mobileDto.getClientId());
       if (clientOptional.isPresent()) {
           Mobile mobile = new Mobile();
           mobile.setClientId(mobileDto.getClientId());
           mobile.setTitle(mobileDto.getTitle());
           mobile.setCost(mobileDto.getCost());
           return mobileRepository.saveMobile(mobile);
       } else throw new NoSuchElementException(String.format("Клиент с идентификатором %s не найден" , mobileDto.getClientId()));
    }
    public Mobile getMobile(UUID id) {
        return mobileRepository.getMobile(id);
    }
    public void delete(UUID id) {
        mobileRepository.deleteMobile(id);
    }

}
