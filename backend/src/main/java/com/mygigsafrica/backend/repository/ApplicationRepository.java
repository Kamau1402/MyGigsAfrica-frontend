package com.mygigsafrica.backend.repository;

import com.mygigsafrica.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByGigId(Long gigId);
    List<Application> findByApplicantId(Long userId);
}

