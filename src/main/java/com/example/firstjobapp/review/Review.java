package com.example.firstjobapp.review;

import com.example.firstjobapp.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String reviewTitle;
    private String reviewContent;
    private double reviewRating;

    @JsonIgnore
    @ManyToOne
    private Company companyToReview;

    public Review() {
    }

    public Company getCompanyToReview() {
        return companyToReview;
    }

    public void setCompanyToReview(Company companyToReview) {
        this.companyToReview = companyToReview;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTtitle) {
        this.reviewTitle = reviewTtitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
}
