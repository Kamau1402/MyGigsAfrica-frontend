package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Gig;
import com.mygigsafrica.backend.repository.GigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GigServiceImpl implements GigService {
    @Autowired
    private GigRepository gigRepository;

    @Override
    public Gig createOrUpdateGig(Gig gig) {
        return gigRepository.save(gig);
    }

    @Override
    public Optional<Gig> getGigById(Long id) {
        return gigRepository.findById(id);
    }

    @Override
    public List<Gig> getGigsByStatus(String status) {
        return gigRepository.findByStatus(status);
    }

    @Override
    public List<Gig> getGigsByClientId(Long clientId) {
        return gigRepository.findByClientId(clientId);
    }

    @Override
    public List<Gig> getAllGigs() {
        return gigRepository.findAll();
    }

    @Override
    public void deleteGig(Long id) {
        gigRepository.deleteById(id);
    }
}

