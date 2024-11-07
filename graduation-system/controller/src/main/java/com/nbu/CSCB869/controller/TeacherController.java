package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.model.Teacher;
import com.nbu.CSCB869.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * Displays a list of all teachers in the system.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping
    public String getAllTeachers(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers/list";
    }

    /**
     * Displays the form to create a new teacher.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/create")
    public String createTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/create";
    }

    /**
     * Saves a new teacher to the system.
     *
     * @param teacher The teacher object to be saved.
     * @return Redirects to the list of all teachers after saving.
     */
    @PostMapping("/create")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    /**
     * Displays the form to edit an existing teacher.
     *
     * @param id    The ID of the teacher to edit.
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/edit/{id}")
    public String editTeacher(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teachers/edit";
    }

    /**
     * Updates an existing teacher.
     *
     * @param id      The ID of the teacher to update.
     * @param teacher The updated teacher object.
     * @return Redirects to the list of all teachers after updating.
     */
    @PostMapping("/edit/{id}")
    public String updateTeacher(@PathVariable("id") Long id,
                                @ModelAttribute("teacher") Teacher teacher) {
        teacher.setId(id);
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    /**
     * Deletes a teacher by their ID.
     *
     * @param id The ID of the teacher to delete.
     * @return Redirects to the list of all teachers after deletion.
     */
    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }
}
