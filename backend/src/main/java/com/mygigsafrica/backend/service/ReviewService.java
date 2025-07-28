 package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review createOrUpdateReview(Review review);
    Optional<Review> getReviewById(Long id);
    List<Review> getReviewsByReviewedUserId(Long reviewedId);
    List<Review> getReviewsByGigId(Long gigId);
    void deleteReview(Long id);
}

