package com.nbu.CSCB869.controller.diploma.defense;

import com.nbu.CSCB869.model.diploma.defense.DiplomaDefense;
import com.nbu.CSCB869.service.diploma.defense.DiplomaDefenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diploma-defenses")
public class DiplomaDefenseController {

    private final DiplomaDefenseService diplomaDefenseService;

    @Autowired
    public DiplomaDefenseController(DiplomaDefenseService diplomaDefenseService) {
        this.diplomaDefenseService = diplomaDefenseService;
    }

    /**
     * Displays a list of all diploma defenses in the system.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping
    public String getAllDiplomaDefenses(Model model) {
        List<DiplomaDefense> defenses = diplomaDefenseService.getAllDefenses();
        model.addAttribute("defenses", defenses);
        return "diploma-defenses/list";
    }

    /**
     * Displays the form to create a new diploma defense.
     *
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/create")
    public String createDiplomaDefenseForm(Model model) {
        model.addAttribute("diplomaDefense", new DiplomaDefense());
        return "diploma-defenses/create";
    }

    /**
     * Saves a new diploma defense to the system.
     *
     * @param diplomaDefense The diploma defense object to be saved.
     * @return Redirects to the list of all defenses after saving.
     */
    @PostMapping("/create")
    public String saveDiplomaDefense(@ModelAttribute("diplomaDefense") DiplomaDefense diplomaDefense) {
        diplomaDefenseService.saveDefense(diplomaDefense);
        return "redirect:/diploma-defenses";
    }

    /**
     * Displays the form to edit an existing diploma defense.
     *
     * @param id    The ID of the diploma defense to edit.
     * @param model The model object to which the data will be added.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/edit/{id}")
    public String editDiplomaDefense(@PathVariable("id") Long id, Model model) {
        DiplomaDefense diplomaDefense = diplomaDefenseService.getDefenseById(id);
        model.addAttribute("diplomaDefense", diplomaDefense);
        return "diploma-defenses/edit";
    }

    /**
     * Updates an existing diploma defense.
     *
     * @param id             The ID of the diploma defense to update.
     * @param diplomaDefense The updated diploma defense object.
     * @return Redirects to the list of all defenses after updating.
     */
    @PostMapping("/edit/{id}")
    public String updateDiplomaDefense(@PathVariable("id") Long id,
                                       @ModelAttribute("diplomaDefense") DiplomaDefense diplomaDefense) {
        diplomaDefense.setId(id);
        diplomaDefenseService.saveDefense(diplomaDefense);
        return "redirect:/diploma-defenses";
    }

    /**
     * Deletes a diploma defense by its ID.
     *
     * @param id The ID of the diploma defense to delete.
     * @return Redirects to the list of all defenses after deletion.
     */
    @GetMapping("/delete/{id}")
    public String deleteDiplomaDefense(@PathVariable("id") Long id) {
        diplomaDefenseService.deleteDefense(id);
        return "redirect:/diploma-defenses";
    }
}
