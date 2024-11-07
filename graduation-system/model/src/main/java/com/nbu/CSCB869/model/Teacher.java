package com.nbu.CSCB869.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing a Teacher in the system.
 * Contains teacher's name and position (e.g., Assistant, Associate Professor).
 */
@Entity
@Data
@Table(name="teacher")
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private TeacherType type;

    public Teacher(String name, TeacherType type) {
        setName(name);
        setType(type);
    }
}
