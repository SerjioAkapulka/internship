package com.intership.repositories;

import com.intership.models.Client;
import com.intership.models.Mobile;
import com.intership.models.Penalty;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface MobileRepository extends CrudRepository<Mobile, UUID> {
    Optional<Mobile> findByClientId(UUID clientId);
}
