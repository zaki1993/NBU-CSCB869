package com.nbu.CSCB869.repository;

import com.nbu.CSCB869.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
