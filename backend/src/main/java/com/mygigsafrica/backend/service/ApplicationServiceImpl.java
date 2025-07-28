package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Application;
import com.mygigsafrica.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application createOrUpdateApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    @Override
    public List<Application> getApplicationsByGigId(Long gigId) {
        return applicationRepository.findByGigId(gigId);
    }

    @Override
    public List<Application> getApplicationsByApplicantId(Long applicantId) {
        return applicationRepository.findByApplicantId(applicantId);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}

