package com.nbu.CSCB869.repository;

import com.nbu.CSCB869.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Student entities.
 * Provides CRUD operations and allows custom queries.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findByFn(String fn);
}
