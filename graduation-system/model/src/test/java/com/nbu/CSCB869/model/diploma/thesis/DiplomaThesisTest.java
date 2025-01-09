package com.nbu.CSCB869.model.diploma.thesis;

import com.nbu.CSCB869.model.Student;
import com.nbu.CSCB869.model.diploma.assignment.DiplomaAssignment;
import com.nbu.CSCB869.model.diploma.thesis.review.ReviewOutcome;
import com.nbu.CSCB869.model.diploma.thesis.review.ThesisReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiplomaThesisTest {

    private DiplomaThesis thesis;
    private DiplomaAssignment mockAssignment;
    private ThesisReview mockReview;
    private Student mockStudent;

    @BeforeEach
    void setUp() {
        thesis = new DiplomaThesis();
        thesis.setId(1L);
        thesis.setTitle("Sample Thesis");
        thesis.setText("This is a sample diploma thesis text.");
        thesis.setUploadTime(LocalDateTime.of(2025, 1, 10, 14, 30));

        // Mock Student
        mockStudent = mock(Student.class);
        when(mockStudent.getUsername()).thenReturn("studentUser");

        // Mock DiplomaAssignment
        mockAssignment = mock(DiplomaAssignment.class);
        when(mockAssignment.getStudent()).thenReturn(mockStudent);
        thesis.setAssignment(mockAssignment);

        // Mock ThesisReview
        mockReview = mock(ThesisReview.class);
        thesis.setReview(mockReview);

        // Set up mocked security context
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn("studentUser");
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void testDefaultValues() {
        assertNotNull(thesis.getTitle(), "Title should not be null.");
        assertNotNull(thesis.getText(), "Text should not be null.");
        assertNotNull(thesis.getUploadTime(), "Upload time should not be null.");
        assertNotNull(thesis.getAssignment(), "Assignment should not be null.");
    }

    @Test
    void testIsReadOnly_NoReview() {
        // If no review exists, check if the current user matches the student's username
        thesis.setReview(null);
        assertFalse(thesis.isReadOnly(), "Thesis should not be read-only when there is no review and user matches.");
    }

    @Test
    void testIsReadOnly_WithPositiveReview() {
        // If a positive review exists, the thesis is read-only
        when(mockReview.getReviewOutcome()).thenReturn(ReviewOutcome.POSITIVE);
        assertTrue(thesis.isReadOnly(), "Thesis should be read-only when a positive review exists.");
    }

    @Test
    void testIsReadOnly_WithNegativeReview() {
        // If a negative review exists, check if the user matches the student's username
        when(mockReview.getReviewOutcome()).thenReturn(ReviewOutcome.NEGATIVE);
        assertFalse(thesis.isReadOnly(), "Thesis should not be read-only with a negative review if the user matches.");
    }

    @Test
    void testIsReadOnly_NonMatchingUser() {
        // Simulate a non-matching user
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn("anotherUser");
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        assertTrue(thesis.isReadOnly(), "Thesis should be read-only when the current user does not match the student.");
    }

    @Test
    void testSetReview() {
        // Update review and verify
        ThesisReview newReview = new ThesisReview();
        thesis.setReview(newReview);
        assertEquals(newReview, thesis.getReview(), "Review should be updated.");
    }

    @Test
    void testSetAssignment() {
        // Update assignment and verify
        DiplomaAssignment newAssignment = new DiplomaAssignment();
        thesis.setAssignment(newAssignment);
        assertEquals(newAssignment, thesis.getAssignment(), "Assignment should be updated.");
    }

    @Test
    void testSetUploadTime() {
        // Update upload time and verify
        LocalDateTime newUploadTime = LocalDateTime.of(2025, 2, 1, 12, 0);
        thesis.setUploadTime(newUploadTime);
        assertEquals(newUploadTime, thesis.getUploadTime(), "Upload time should be updated.");
    }

    @Test
    void testSetText() {
        // Update text and verify
        String newText = "Updated diploma thesis text.";
        thesis.setText(newText);
        assertEquals(newText, thesis.getText(), "Text should be updated.");
    }

    @Test
    void testSetTitle() {
        // Update title and verify
        String newTitle = "Updated Thesis Title";
        thesis.setTitle(newTitle);
        assertEquals(newTitle, thesis.getTitle(), "Title should be updated.");
    }
}
