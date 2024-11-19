package com.nbu.CSCB869.service;

import com.nbu.CSCB869.model.diploma.thesis.ThesisReview;
import com.nbu.CSCB869.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing Review entities.
 * Provides methods to retrieve, save, and manipulate review data for diploma assignments.
 */
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * Retrieves all reviews in the system.
     *
     * @return List of all reviews
     */
    public List<ThesisReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    /**
     * Finds a review by its ID.
     *
     * @param id ID of the review
     * @return The review if found, or null if not found
     */
    public ThesisReview getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    /**
     * Saves or updates a review record.
     *
     * @param review Review entity to save
     * @return The saved review entity
     */
    public ThesisReview saveReview(ThesisReview review) {
        return reviewRepository.save(review);
    }

    /**
     * Deletes a review by its ID.
     *
     * @param id ID of the review to delete
     */
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    /**
     * Counts the number of reviews with a specified conclusion.
     *
     * @param conclusion Conclusion type (e.g., "Positive" or "Negative")
     * @return Count of reviews with the specified conclusion
     */
    public long countReviewsByConclusion(String conclusion) {
        return reviewRepository.countByConclusion(conclusion);
    }
}
