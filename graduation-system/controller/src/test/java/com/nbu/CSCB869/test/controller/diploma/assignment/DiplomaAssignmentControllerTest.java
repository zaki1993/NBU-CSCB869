package com.nbu.CSCB869.test.controller.diploma.assignment;

import com.nbu.CSCB869.controller.diploma.assignment.DiplomaAssignmentController;
import com.nbu.CSCB869.global.AccessControlConfig;
import com.nbu.CSCB869.model.Student;
import com.nbu.CSCB869.model.Teacher;
import com.nbu.CSCB869.model.diploma.assignment.DiplomaAssignment;
import com.nbu.CSCB869.service.StudentService;
import com.nbu.CSCB869.service.TeacherService;
import com.nbu.CSCB869.service.diploma.assignment.DiplomaAssignmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DiplomaAssignmentControllerTest {
/*
    @InjectMocks
    private DiplomaAssignmentController diplomaAssignmentController;

    @Mock
    private DiplomaAssignmentService diplomaAssignmentService;

    @Mock
    private StudentService studentService;

    @Mock
    private TeacherService teacherService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDiplomaAssignments_AsStudent() {
        // Simulate logged-in user as a student
        when(AccessControlConfig.isStudent()).thenReturn(true);
        List<DiplomaAssignment> assignments = new ArrayList<>();
        DiplomaAssignment approvedAssignment = new DiplomaAssignment();
        approvedAssignment.setApproved(true);
        assignments.add(approvedAssignment);

        DiplomaAssignment unapprovedAssignment = new DiplomaAssignment();
        unapprovedAssignment.setApproved(false);
        assignments.add(unapprovedAssignment);

        when(diplomaAssignmentService.getAllAssignments()).thenReturn(assignments);

        String view = diplomaAssignmentController.getAllDiplomaAssignments(model);

        verify(model).addAttribute(eq("assignments"), argThat((List list) -> list.size() == 1)); // Only approved
        assertEquals("diploma-assignments/list", view);
    }

    @Test
    void testGetAllDiplomaAssignments_AsTeacher() {
        // Simulate logged-in user as a teacher
        when(AccessControlConfig.isStudent()).thenReturn(false);
        List<DiplomaAssignment> assignments = new ArrayList<>();
        assignments.add(new DiplomaAssignment());

        when(diplomaAssignmentService.getAllAssignments()).thenReturn(assignments);

        String view = diplomaAssignmentController.getAllDiplomaAssignments(model);

        verify(model).addAttribute("assignments", assignments); // All assignments
        assertEquals("diploma-assignments/list", view);
    }

    @Test
    void testGetDiplomaAssignmentsForUser() {
        List<DiplomaAssignment> assignments = new ArrayList<>();
        DiplomaAssignment assignment = new DiplomaAssignment();
        Student student = new Student();
        student.setUsername("testStudent");
        assignment.setStudent(student);
        assignments.add(assignment);

        when(diplomaAssignmentService.getAllAssignments()).thenReturn(assignments);
        when(AccessControlConfig.getUsername()).thenReturn("testStudent");

        String view = diplomaAssignmentController.getDiplomaAssignmentsForUser(model);

        verify(model).addAttribute(eq("assignments"), argThat((List list) -> list.size() == 1));
        verify(model).addAttribute("userOnly", true);
        assertEquals("diploma-assignments/list", view);
    }

    @Test
    void testCreateDiplomaAssignmentForm() {
        String view = diplomaAssignmentController.createDiplomaAssignmentForm(model);

        verify(model).addAttribute(eq("diplomaAssignment"), any(DiplomaAssignment.class));
        verify(model).addAttribute(eq("students"), anyList());
        assertEquals("diploma-assignments/create-edit", view);
    }

    @Test
    void testSaveDiplomaAssignment() {
        DiplomaAssignment diplomaAssignment = new DiplomaAssignment();
        Student student = new Student();
        student.setUsername("testStudent");
        Teacher teacher = new Teacher();
        teacher.setUsername("testTeacher");

        when(studentService.getStudentByFn("12345")).thenReturn(student);
        when(AccessControlConfig.getUsername()).thenReturn("testTeacher");
        when(teacherService.getTeacherByUsername("testTeacher")).thenReturn(teacher);

        String view = diplomaAssignmentController.saveDiplomaAssignment(diplomaAssignment, "12345");

        verify(diplomaAssignmentService).saveAssignment(diplomaAssignment);
        verify(diplomaAssignment).setStudent(student);
        verify(diplomaAssignment).setTeacher(teacher);
        assertEquals("redirect:/diploma-assignments", view);
    }

    @Test
    void testApproveDiplomaAssignment() {
        String view = diplomaAssignmentController.approveDiplomaAssignment(1L, model);

        verify(diplomaAssignmentService).approveDiplomaAssignment(1L);
        assertEquals("redirect:/diploma-assignments", view);
    }

    @Test
    void testEditDiplomaAssignment() {
        DiplomaAssignment existingAssignment = new DiplomaAssignment();
        when(diplomaAssignmentService.getAssignmentById(1L)).thenReturn(existingAssignment);

        String view = diplomaAssignmentController.getEditDiplomaAssignment(1L, model);

        verify(model).addAttribute("diplomaAssignment", existingAssignment);
        verify(model).addAttribute(eq("students"), anyList());
        assertEquals("diploma-assignments/create-edit", view);
    }

    @Test
    void testDeleteDiplomaAssignment() {
        ResponseEntity response = diplomaAssignmentController.deleteDiplomaAssignment(1L);

        verify(diplomaAssignmentService).deleteAssignment(1L);
        assertEquals(200, response.getStatusCode().value());
    }*/
}
