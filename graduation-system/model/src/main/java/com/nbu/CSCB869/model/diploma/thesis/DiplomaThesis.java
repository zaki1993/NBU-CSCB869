package com.nbu.CSCB869.model.diploma.thesis;

import com.nbu.CSCB869.model.Student;
import com.nbu.CSCB869.model.diploma.assignment.DiplomaAssignment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class DiplomaThesis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="upload_time")
    private LocalDateTime uploadTime;

    @OneToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private DiplomaAssignment assignment;

    @OneToOne(mappedBy = "thesis", targetEntity = ThesisReview.class, fetch=FetchType.LAZY)
    private ThesisReview review;

    @Transient
    public boolean isReadOnly() {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        // If there is review, then we are read only
        return review != null || !currentUser.equals(assignment.getStudent().getUsername());
    }
}
