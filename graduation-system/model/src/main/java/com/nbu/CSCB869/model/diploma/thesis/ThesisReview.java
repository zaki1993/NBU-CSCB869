package com.nbu.CSCB869.model.diploma.thesis;

import com.nbu.CSCB869.model.diploma.assignment.DiplomaAssignment;
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
public class ThesisReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 2000)
    private String text;

    @Column(nullable = false)
    private String conclusion;

    @OneToOne
    @JoinColumn(name = "thesis_id", nullable = false)
    private DiplomaThesis thesis;
}
