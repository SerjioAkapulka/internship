package com.intership.repositories;

import com.intership.models.Internet;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InternetRepository extends CrudRepository<Internet, UUID> {
    Internet getInternet(UUID clientId);
}
