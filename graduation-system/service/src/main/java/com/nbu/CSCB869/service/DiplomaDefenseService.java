package com.nbu.CSCB869.service;

import com.nbu.CSCB869.model.DiplomaDefense;
import com.nbu.CSCB869.repository.DiplomaDefenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing Diploma Defense entities.
 * Provides methods to retrieve and manipulate diploma defense data.
 */
@Service
public class DiplomaDefenseService {

    private final DiplomaDefenseRepository diplomaDefenseRepository;

    @Autowired
    public DiplomaDefenseService(DiplomaDefenseRepository diplomaDefenseRepository) {
        this.diplomaDefenseRepository = diplomaDefenseRepository;
    }

    /**
     * Retrieves all diploma defenses.
     *
     * @return List of all diploma defenses
     */
    public List<DiplomaDefense> getAllDefenses() {
        return diplomaDefenseRepository.findAll();
    }

    /**
     * Finds a diploma defense by its ID.
     *
     * @param id ID of the diploma defense
     * @return The diploma defense, if found
     */
    public DiplomaDefense getDefenseById(Long id) {
        return diplomaDefenseRepository.findById(id).orElse(null);
    }

    /**
     * Saves or updates a diploma defense record.
     *
     * @param defense Diploma defense entity to save
     * @return Saved diploma defense entity
     */
    public DiplomaDefense saveDefense(DiplomaDefense defense) {
        return diplomaDefenseRepository.save(defense);
    }

    /**
     * Deletes a diploma defense by ID.
     *
     * @param id ID of the diploma defense to delete
     */
    public void deleteDefense(Long id) {
        diplomaDefenseRepository.deleteById(id);
    }
}
