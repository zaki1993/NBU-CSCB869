package com.nbu.CSCB869.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entity representing a Review for a Diploma Assignment.
 * Includes date, text, conclusion (positive/negative), and reference to the assignment being reviewed.
 */
@Entity
@Data
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 2000)
    private String text;

    @Column(nullable = false)
    private String conclusion; // Положителна или Отрицателна

    // Свързване към дипломната работа, която се рецензира
    @ManyToOne
    @JoinColumn(name = "diploma_assignment_id", nullable = false)
    private DiplomaAssignment diplomaAssignment;
}
