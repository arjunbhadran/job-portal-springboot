package com.example.firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    Review getReviewById(Long companyId,Long reviewId);
    Boolean createReview(Long companyId,Review review);
    Review updateReview(Long companyId, Long reviewId, Review review);
    String deleteReview(Long reviewId);
}
