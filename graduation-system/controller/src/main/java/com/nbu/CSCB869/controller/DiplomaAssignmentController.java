package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.global.AccessControlConfig;
import com.nbu.CSCB869.model.DiplomaAssignment;
import com.nbu.CSCB869.model.Student;
import com.nbu.CSCB869.model.Teacher;
import com.nbu.CSCB869.service.DiplomaAssignmentService;
import com.nbu.CSCB869.service.StudentService;
import com.nbu.CSCB869.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diploma-assignments")
@RequiredArgsConstructor
public class DiplomaAssignmentController {

    private final DiplomaAssignmentService diplomaAssignmentService;

    private final StudentService studentService;
    private final TeacherService teacherService;

    /**
     * Displays all diploma assignments in the system.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping
    public String getAllDiplomaAssignments(Model model) {
        List<DiplomaAssignment> assignments = diplomaAssignmentService.getAllAssignments();
        model.addAttribute("assignments", assignments);
        return "diploma-assignments/list";
    }

    /**
     * Displays the form to create a new diploma assignment.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/create")
    @PreAuthorize("hasAuthority('TEACHER')")
    public String createDiplomaAssignmentForm(Model model) {
        model.addAttribute("diplomaAssignment", new DiplomaAssignment());
        model.addAttribute("students", studentService.getAllStudents());
        return "diploma-assignments/create-edit";
    }

    /**
     * Saves a new diploma assignment to the system.
     *
     * @param diplomaAssignment The diploma assignment object to be saved.
     * @return Redirects to the list of all assignments after saving.
     */
    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/create")
    public String saveDiplomaAssignment(@ModelAttribute("diplomaAssignment") DiplomaAssignment diplomaAssignment,
                                        @RequestParam("student.fn") String studentFn) {
        // Set the student
        Student s = studentService.getStudentByFn(studentFn);
        diplomaAssignment.setStudent(s);

        // Set the teacher to be current logged-in user
        Teacher t = getTeacherFromContext();
        diplomaAssignment.setTeacher(t);

        diplomaAssignmentService.saveAssignment(diplomaAssignment);
        return "redirect:/diploma-assignments";
    }

    /**
     * Displays the form to edit an existing diploma assignment.
     *
     * @param id    The ID of the diploma assignment to edit.
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public String editDiplomaAssignment(@PathVariable("id") Long id, Model model) {
        DiplomaAssignment diplomaAssignment = diplomaAssignmentService.getAssignmentById(id).get();
        model.addAttribute("diplomaAssignment", diplomaAssignment);
        model.addAttribute("students", studentService.getAllStudents());
        return "diploma-assignments/create-edit";
    }

    /**
     * Updates an existing diploma assignment.
     *
     * @param id                The ID of the diploma assignment to update.
     * @param diplomaAssignment The updated diploma assignment object.
     * @return Redirects to the list of all assignments after updating.
     */
    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public String updateDiplomaAssignment(@PathVariable("id") Long id,
                                          @ModelAttribute("diplomaAssignment") DiplomaAssignment diplomaAssignment,
                                          @RequestParam("student.fn") String studentFn) {
        DiplomaAssignment toModify = diplomaAssignmentService.getAssignmentById(diplomaAssignment.getId()).get();
        toModify.setId(id);

        Student s = studentService.getStudentByFn(studentFn);
        toModify.setStudent(s);
        toModify.setTasks(diplomaAssignment.getTasks());
        toModify.setPurpose(diplomaAssignment.getPurpose());
        toModify.setTechnologies(diplomaAssignment.getTechnologies());
        toModify.setTitle(diplomaAssignment.getTitle());

        diplomaAssignmentService.saveAssignment(toModify);
        return "redirect:/diploma-assignments";
    }

    /**
     * Deletes a diploma assignment by its ID.
     *
     * @param id The ID of the diploma assignment to delete.
     * @return Redirects to the list of all assignments after deletion.
     */
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public String deleteDiplomaAssignment(@PathVariable("id") Long id) {
        diplomaAssignmentService.deleteAssignment(id);
        return "redirect:/diploma-assignments";
    }

    private Teacher getTeacherFromContext() {
        String username = AccessControlConfig.getUsername();
        return teacherService.getTeacherByUsername(username);
    }
}
