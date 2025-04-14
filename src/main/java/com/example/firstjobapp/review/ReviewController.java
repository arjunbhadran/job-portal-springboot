package com.example.firstjobapp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/public/companies/{companyId}/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/admin/companies/{companyId}/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        if(reviewService.createReview(companyId, review)) {
            return new ResponseEntity<>("Review created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Review not created", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/public/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

    @DeleteMapping("/admin/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        String status=reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/admin/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review){
        if(reviewService.updateReview(reviewId, companyId, review)) {
            return new ResponseEntity<>("Review has been updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review not updated", HttpStatus.BAD_REQUEST);
        }
    }
}
