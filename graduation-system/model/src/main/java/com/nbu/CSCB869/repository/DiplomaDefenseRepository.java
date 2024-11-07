package com.nbu.CSCB869.repository;

import com.nbu.CSCB869.model.DiplomaDefense;
import com.nbu.CSCB869.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for managing DiplomaDefense entities.
 * Provides CRUD operations and custom queries for fetching defenses by date and score criteria.
 */
@Repository
public interface DiplomaDefenseRepository extends JpaRepository<DiplomaDefense, Long> {

    /**
     * Finds all defenses conducted within a specified date range.
     *
     * @param startDate Start date of the range
     * @param endDate   End date of the range
     * @return List of defenses within the specified date range
     */
    List<DiplomaDefense> findByDefenseDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Finds all defenses with scores within a specified range.
     *
     * @param minScore Minimum score
     * @param maxScore Maximum score
     * @return List of defenses within the specified score range
     */
    List<DiplomaDefense> findByScoreBetween(Double minScore, Double maxScore);

/*    *//**
     * Counts the number of students who successfully defended under a specified supervisor.
     *
     * @param supervisor The teacher who supervised the diploma defense
     * @param passingScore Minimum passing score
     * @return Count of students who defended successfully
     *//*
    long countByTeacherAndScoreGreaterThanEqual(Teacher supervisor, Double passingScore);*/
}
