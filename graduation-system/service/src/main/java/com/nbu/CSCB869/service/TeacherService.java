package com.nbu.CSCB869.service;

import com.nbu.CSCB869.model.Teacher;
import com.nbu.CSCB869.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing Teacher entities.
 * Provides methods to retrieve and manage teacher data.
 */
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    /**
     * Retrieves all teachers in the system.
     *
     * @return List of all teachers
     */
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    /**
     * Finds a teacher by their ID.
     *
     * @param id ID of the teacher
     * @return The teacher, if found
     */
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    /**
     * Saves or updates a teacher record.
     *
     * @param teacher Teacher entity to save
     * @return Saved teacher entity
     */
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    /**
     * Deletes a teacher by ID.
     *
     * @param id ID of the teacher to delete
     */
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher getTeacherByUsername(String username) {
        return teacherRepository.findByUsername(username);
    }
}
