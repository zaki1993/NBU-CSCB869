package com.nbu.CSCB869.service;

import com.nbu.CSCB869.model.Student;
import com.nbu.CSCB869.repository.StudentRepository;
import com.nbu.CSCB869.service.exceptions.StudentAlreadyExistsException;
import com.nbu.CSCB869.service.exceptions.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createStudent(Student s) {
        if (studentRepository.findByFn(s.getFn()).isPresent()) {
            throw new StudentAlreadyExistsException(s.getFn());
        }
        return studentRepository.save(s);
    }

    public Student editStudent(Student s) {
        Student toEdit = getStudent(s.getFn());
        // ID and fn cannot be updated
        toEdit.setName(s.getName());
        return studentRepository.save(toEdit);
    }

    public void deleteStudent(String fn) {
        Student toDelete = getStudent(fn);
        studentRepository.delete(toDelete);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(String fn) {
        return studentRepository.findByFn(fn).orElseThrow(() -> new StudentNotFoundException(fn));
    }
}
