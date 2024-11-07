package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.api.StudentApi;
import com.nbu.CSCB869.model.Student;
import com.nbu.CSCB869.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
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
    }*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Displays a list of all students in the system.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/list";
    }

    /**
     * Displays the form to create a new student.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/create";
    }

    /**
     * Saves a new student to the system.
     *
     * @param student The student object to be saved.
     * @return Redirects to the list of all students after saving.
     */
    @PostMapping("/create")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    /**
     * Displays the form to edit an existing student.
     *
     * @param id    The ID of the student to edit.
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "students/edit";
    }

    /**
     * Updates an existing student.
     *
     * @param id      The ID of the student to update.
     * @param student The updated student object.
     * @return Redirects to the list of all students after updating.
     */
    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id The ID of the student to delete.
     * @return Redirects to the list of all students after deletion.
     */
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
