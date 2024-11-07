package com.nbu.CSCB869.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing a Diploma Assignment.
 * Contains information about the diploma topic, purpose, tasks, technologies, student, and supervisor.
 */
@Entity
@Data
@NoArgsConstructor
public class DiplomaAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String purpose;
    private String tasks;
    private String technologies;
    private boolean approved;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Teacher teacher;
}
