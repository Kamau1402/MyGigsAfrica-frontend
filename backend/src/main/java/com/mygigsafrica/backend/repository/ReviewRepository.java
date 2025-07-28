package com.mygigsafrica.backend.repository;

import com.mygigsafrica.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByReviewedId(Long reviewedId);
    List<Review> findByGigId(Long gigId);
}

