package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Gig;
import java.util.List;
import java.util.Optional;

public interface GigService {
    Gig createOrUpdateGig(Gig gig);
    Optional<Gig> getGigById(Long id);
    List<Gig> getGigsByStatus(String status);
    List<Gig> getGigsByClientId(Long clientId);
    List<Gig> getAllGigs();
    void deleteGig(Long id);
}

