package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.api.StudentApi;
import com.nbu.CSCB869.model.Student;
import com.nbu.CSCB869.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {
    private final StudentService studentService;

    @Override
    public ResponseEntity<Student> createStudent(Student s) {
        return ResponseEntity.ok().body(studentService.createStudent(s));
    }

    @Override
    public ResponseEntity<Student> getStudent(String fn) {
        return ResponseEntity.ok(studentService.getStudent(fn));
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @Override
    public ResponseEntity<Void> deleteStudent(String fn) {
        studentService.deleteStudent(fn);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Student> editStudent(Student s) {
        return ResponseEntity.ok().body(studentService.editStudent(s));
    }
}
