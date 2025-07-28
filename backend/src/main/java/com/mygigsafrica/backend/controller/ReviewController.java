package com.mygigsafrica.backend.controller;

import com.mygigsafrica.backend.entity.Review;
import com.mygigsafrica.backend.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createOrUpdateReview(@RequestBody Review review) {
        Review savedReview = reviewService.createOrUpdateReview(review);
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{reviewedId}")
    public ResponseEntity<List<Review>> getReviewsByReviewedUser(@PathVariable Long reviewedId) {
        return ResponseEntity.ok(reviewService.getReviewsByReviewedUserId(reviewedId));
    }

    @GetMapping("/gig/{gigId}")
    public ResponseEntity<List<Review>> getReviewsByGig(@PathVariable Long gigId) {
        return ResponseEntity.ok(reviewService.getReviewsByGigId(gigId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}

