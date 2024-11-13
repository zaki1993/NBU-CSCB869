package com.nbu.CSCB869.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nbu.CSCB869.service.DiplomaAssignmentService;
import com.nbu.CSCB869.service.ReviewService;
import com.nbu.CSCB869.service.DiplomaDefenseService;
import com.nbu.CSCB869.service.StudentService;

/**
 * HomeController handles the requests related to the home page and provides
 * a dashboard view for the users to navigate to various sections of the system.
 * It serves data related to students, diploma assignments, reviews, and diploma defenses.
 */
@Controller
public class HomeController {

    private final StudentService studentService;
    private final DiplomaAssignmentService diplomaAssignmentService;
    private final ReviewService reviewService;
    private final DiplomaDefenseService diplomaDefenseService;

    /**
     * Constructor injection for services.
     *
     * @param studentService The service that handles student data.
     * @param diplomaAssignmentService The service that handles diploma assignments.
     * @param reviewService The service that handles reviews.
     * @param diplomaDefenseService The service that handles diploma defenses.
     */
    @Autowired
    public HomeController(StudentService studentService,
                          DiplomaAssignmentService diplomaAssignmentService,
                          ReviewService reviewService,
                          DiplomaDefenseService diplomaDefenseService) {
        this.studentService = studentService;
        this.diplomaAssignmentService = diplomaAssignmentService;
        this.reviewService = reviewService;
        this.diplomaDefenseService = diplomaDefenseService;
    }

    /**
     * Handles the GET request to the home page, prepares necessary data and
     * returns the home template to be displayed.
     *
     * @param model The model object used to pass data to the template.
     * @return The name of the home template (home.html).
     */
    @GetMapping("/")
    public String homePage(Model model) {
        // You can add more data as needed
        model.addAttribute("studentsCount", studentService.getAllStudents().size());
        model.addAttribute("diplomaAssignmentsCount", diplomaAssignmentService.getAllAssignments().size());
        model.addAttribute("reviewsCount", reviewService.getAllReviews().size());
        model.addAttribute("diplomaDefensesCount", diplomaDefenseService.getAllDefenses().size());

        return "home";
    }
}
