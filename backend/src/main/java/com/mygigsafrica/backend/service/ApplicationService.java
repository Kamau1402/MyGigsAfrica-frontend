package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Application;
import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application createOrUpdateApplication(Application application);
    Optional<Application> getApplicationById(Long id);
    List<Application> getApplicationsByGigId(Long gigId);
    List<Application> getApplicationsByApplicantId(Long applicantId);
    List<Application> getAllApplications();
    void deleteApplication(Long id);
}

