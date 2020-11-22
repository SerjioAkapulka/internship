package com.intership.repositories;

import com.intership.models.Contract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContractRepository extends CrudRepository<Contract, UUID> {
    @Query(value = "select * from contract where client_id = ?", nativeQuery = true)
    Optional<Contract> findByClientId(UUID clientId);

    Optional<Contract> findByIdAndClientId(UUID id, UUID clientId);
}
