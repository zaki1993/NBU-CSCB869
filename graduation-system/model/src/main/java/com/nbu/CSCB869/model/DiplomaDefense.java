package com.nbu.CSCB869.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Entity representing a Diploma Defense procedure.
 * Contains details such as defense date, student, supervising teacher, and defense score.
 */
@Entity
@Data
@NoArgsConstructor
public class DiplomaDefense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate defenseDate;

    private Double score;

    @ManyToMany
    private List<Student> students;

    @ManyToMany
    private List<Teacher> teachers;
}
