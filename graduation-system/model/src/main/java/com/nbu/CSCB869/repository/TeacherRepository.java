package com.nbu.CSCB869.repository;

import com.nbu.CSCB869.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Teacher entities.
 * Provides CRUD operations for Teacher data.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
