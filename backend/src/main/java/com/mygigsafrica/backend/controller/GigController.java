package com.mygigsafrica.backend.controller;

import com.mygigsafrica.backend.entity.Gig;
import com.mygigsafrica.backend.service.GigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gigs")
public class GigController {
    private final GigService gigService;

    public GigController(GigService gigService) {
        this.gigService = gigService;
    }

    @PostMapping
    public ResponseEntity<Gig> createOrUpdateGig(@RequestBody Gig gig) {
        Gig savedGig = gigService.createOrUpdateGig(gig);
        return ResponseEntity.ok(savedGig);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gig> getGigById(@PathVariable Long id) {
        Optional<Gig> optGig = gigService.getGigById(id);
        return optGig.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Gig>> getAllGigs() {
        return ResponseEntity.ok(gigService.getAllGigs());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Gig>> getGigsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(gigService.getGigsByStatus(status));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Gig>> getGigsByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(gigService.getGigsByClientId(clientId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGig(@PathVariable Long id) {
        gigService.deleteGig(id);
        return ResponseEntity.noContent().build();
    }
}

