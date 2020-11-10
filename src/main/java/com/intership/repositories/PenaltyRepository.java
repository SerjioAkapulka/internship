package com.intership.repositories;

import com.intership.models.Penalty;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PenaltyRepository extends CrudRepository<Penalty, UUID> {
}
