package com.mygigsafrica.backend.repository;

import com.mygigsafrica.backend.entity.Gig;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GigRepository extends JpaRepository<Gig, Long> {
    List<Gig> findByStatus(String status);
    List<Gig> findByClientId(Long clientId);
}

