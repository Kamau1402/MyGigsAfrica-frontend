package com.mygigsafrica.backend.controller;

import com.mygigsafrica.backend.entity.Application;
import com.mygigsafrica.backend.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> createOrUpdateApplication(@RequestBody Application application) {
        Application savedApplication = applicationService.createOrUpdateApplication(application);
        return ResponseEntity.ok(savedApplication);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Optional<Application> app = applicationService.getApplicationById(id);
        return app.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/gig/{gigId}")
    public ResponseEntity<List<Application>> getApplicationsByGig(@PathVariable Long gigId) {
        return ResponseEntity.ok(applicationService.getApplicationsByGigId(gigId));
    }

    @GetMapping("/applicant/{userId}")
    public ResponseEntity<List<Application>> getApplicationsByApplicant(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationService.getApplicationsByApplicantId(userId));
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}

