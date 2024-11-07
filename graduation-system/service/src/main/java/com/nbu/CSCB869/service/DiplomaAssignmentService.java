package com.nbu.CSCB869.service;

import com.nbu.CSCB869.model.DiplomaAssignment;
import com.nbu.CSCB869.model.Teacher;
import com.nbu.CSCB869.repository.DiplomaAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing DiplomaAssignment entities.
 * Handles business logic and data manipulation for diploma assignments.
 */
@Service
@Transactional
public class DiplomaAssignmentService {

    private final DiplomaAssignmentRepository diplomaAssignmentRepository;

    @Autowired
    public DiplomaAssignmentService(DiplomaAssignmentRepository diplomaAssignmentRepository) {
        this.diplomaAssignmentRepository = diplomaAssignmentRepository;
    }

    /**
     * Retrieves all diploma assignments.
     *
     * @return List of all diploma assignments
     */
    public List<DiplomaAssignment> getAllAssignments() {
        return diplomaAssignmentRepository.findAll();
    }

    /**
     * Retrieves a specific diploma assignment by its ID.
     *
     * @param id ID of the assignment
     * @return Optional containing the found assignment or empty if not found
     */
    public Optional<DiplomaAssignment> getAssignmentById(Long id) {
        return diplomaAssignmentRepository.findById(id);
    }

    /**
     * Saves or updates a diploma assignment.
     *
     * @param assignment The diploma assignment to save or update
     * @return The saved diploma assignment
     */
    public DiplomaAssignment saveAssignment(DiplomaAssignment assignment) {
        return diplomaAssignmentRepository.save(assignment);
    }

    /**
     * Deletes a diploma assignment by its ID.
     *
     * @param id ID of the assignment to delete
     */
    public void deleteAssignment(Long id) {
        diplomaAssignmentRepository.deleteById(id);
    }

    /**
     * Retrieves all approved diploma assignments.
     *
     * @return List of approved assignments
     */
    public List<DiplomaAssignment> getApprovedAssignments() {
        return diplomaAssignmentRepository.findByApproved(true);
    }

    /**
     * Retrieves diploma assignments containing a specific keyword in the title.
     *
     * @param title Keyword to search in the title
     * @return List of assignments with titles containing the specified keyword
     */
    public List<DiplomaAssignment> getAssignmentsByTitle(String title) {
        return diplomaAssignmentRepository.findByTitleContaining(title);
    }

    /**
     * Retrieves diploma assignments supervised by a specified teacher.
     *
     * @param supervisor supervisor teacher
     * @return List of assignments supervised by the specified teacher
     */
    public List<DiplomaAssignment> getAssignmentsByTeacher(Teacher supervisor) {
        return diplomaAssignmentRepository.findByTeacher(supervisor);
    }
}
