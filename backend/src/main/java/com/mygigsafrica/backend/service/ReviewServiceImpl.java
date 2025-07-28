package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Review;
import com.mygigsafrica.backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createOrUpdateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> getReviewsByReviewedUserId(Long reviewedId) {
        return reviewRepository.findByReviewedId(reviewedId);
    }

    @Override
    public List<Review> getReviewsByGigId(Long gigId) {
        return reviewRepository.findByGigId(gigId);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}

