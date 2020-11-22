package com.intership.repositories;

import com.intership.exception.NotFoundException;
import com.intership.models.Penalty;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PenaltyRepo {

    private final PenaltyRepository penaltyRepository;

    public PenaltyRepo(PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }

    public Penalty getPenalty(UUID id) {
        Optional<Penalty> penaltyOptional = penaltyRepository.findById(id);
        if(penaltyOptional.isPresent()) {
            return penaltyOptional.get();
        } else {
            throw new NotFoundException("Информация о штрафах не найдена.");
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
