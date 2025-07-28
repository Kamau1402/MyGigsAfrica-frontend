package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Profile;
import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile createOrUpdate(Profile profile);
    Optional<Profile> getProfileById(Long id);
    Optional<Profile> getProfileByUserId(Long userId);
    List<Profile> getAllProfiles();
    void deleteProfile(Long id);
}

