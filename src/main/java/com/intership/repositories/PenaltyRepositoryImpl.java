package com.intership.repositories;

import com.intership.models.Penalty;

import java.util.Optional;
import java.util.UUID;

public class PenaltyRepositoryImpl {

    private final PenaltyRepository penaltyRepository;

    public PenaltyRepositoryImpl(PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }


}
