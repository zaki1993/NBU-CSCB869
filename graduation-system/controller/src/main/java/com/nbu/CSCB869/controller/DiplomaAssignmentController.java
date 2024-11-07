package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.model.DiplomaAssignment;
import com.nbu.CSCB869.service.DiplomaAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diploma-assignments")
public class DiplomaAssignmentController {

    private final DiplomaAssignmentService diplomaAssignmentService;

    @Autowired
    public DiplomaAssignmentController(DiplomaAssignmentService diplomaAssignmentService) {
        this.diplomaAssignmentService = diplomaAssignmentService;
    }

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
        return "diplomaAssignments/list";
    }

    /**
     * Displays the form to create a new diploma assignment.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/create")
    public String createDiplomaAssignmentForm(Model model) {
        model.addAttribute("diplomaAssignment", new DiplomaAssignment());
        return "diplomaAssignments/create";
    }

    /**
     * Saves a new diploma assignment to the system.
     *
     * @param diplomaAssignment The diploma assignment object to be saved.
     * @return Redirects to the list of all assignments after saving.
     */
    @PostMapping("/create")
    public String saveDiplomaAssignment(@ModelAttribute("diplomaAssignment") DiplomaAssignment diplomaAssignment) {
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
    public String editDiplomaAssignment(@PathVariable("id") Long id, Model model) {
        DiplomaAssignment diplomaAssignment = diplomaAssignmentService.getAssignmentById(id).get();
        model.addAttribute("diplomaAssignment", diplomaAssignment);
        return "diplomaAssignments/edit";
    }

    /**
     * Updates an existing diploma assignment.
     *
     * @param id                The ID of the diploma assignment to update.
     * @param diplomaAssignment The updated diploma assignment object.
     * @return Redirects to the list of all assignments after updating.
     */
    @PostMapping("/edit/{id}")
    public String updateDiplomaAssignment(@PathVariable("id") Long id,
                                          @ModelAttribute("diplomaAssignment") DiplomaAssignment diplomaAssignment) {
        diplomaAssignment.setId(id);
        diplomaAssignmentService.saveAssignment(diplomaAssignment);
        return "redirect:/diploma-assignments";
    }

    /**
     * Deletes a diploma assignment by its ID.
     *
     * @param id The ID of the diploma assignment to delete.
     * @return Redirects to the list of all assignments after deletion.
     */
    @GetMapping("/delete/{id}")
    public String deleteDiplomaAssignment(@PathVariable("id") Long id) {
        diplomaAssignmentService.deleteAssignment(id);
        return "redirect:/diploma-assignments";
    }
}
