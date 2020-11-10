package com.intership.repositories;

import com.intership.models.Penalty;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class PenaltyRepositoryImpl {

    private final PenaltyRepository penaltyRepository;

    public PenaltyRepositoryImpl(PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }

    public Penalty getPenalty(UUID id) {
        Optional<Penalty> penaltyOptional = penaltyRepository.findById(id);
        if(penaltyOptional.isPresent()) {
            return penaltyOptional.get();
        } else {
            throw new NoSuchElementException("Информация не найдена.");
        }
    }

    public Penalty savePenalty(Penalty penalty) {
        penaltyRepository.save(penalty);
        return penalty;
    }

    public void deletePenalty(UUID id) {
        Penalty penalty = getPenalty(id);
        penaltyRepository.delete(penalty);
    }

}
