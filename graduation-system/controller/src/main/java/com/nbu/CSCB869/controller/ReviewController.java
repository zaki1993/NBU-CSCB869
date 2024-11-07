package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.model.Review;
import com.nbu.CSCB869.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Review entities.
 * Provides endpoints for retrieving, creating, updating, and deleting reviews.
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Retrieves a list of all reviews.
     *
     * @return List of all reviews
     */
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    /**
     * Retrieves a review by its ID.
     *
     * @param id ID of the review
     * @return The review, or 404 if not found
     */
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    /**
     * Creates a new review or updates an existing one.
     *
     * @param review The review entity to create or update
     * @return The created/updated review
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createOrUpdateReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    /**
     * Deletes a review by its ID.
     *
     * @param id ID of the review to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    /**
     * Counts the number of reviews with a specific conclusion.
     *
     * @param conclusion Conclusion type (e.g., "Positive" or "Negative")
     * @return The count of reviews with the specified conclusion
     */
    @GetMapping("/count/{conclusion}")
    public long countReviewsByConclusion(@PathVariable String conclusion) {
        return reviewService.countReviewsByConclusion(conclusion);
    }
}
