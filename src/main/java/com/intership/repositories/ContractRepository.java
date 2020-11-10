package com.intership.repositories;

import com.intership.models.Client;
import com.intership.models.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContractRepository extends CrudRepository<Contract, UUID> {

}
