package org.gso.profiles.service;

import java.time.LocalDateTime;

import org.gso.profiles.model.ProfileModel;
import org.gso.profiles.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProfileServiceTest {

    @Autowired
    ProfileService profileService;

    @MockitoBean
    ProfileRepository profileRepository;

    @Test
    public void testProfileCreation() {
        ProfileModel profileModel = ProfileModel.builder().userId("toto").build();
        ProfileModel createdProfile = ProfileModel.builder()
                        .id("myId")
                        .userId("toto")
                        .created(LocalDateTime.now())
                        .modified(LocalDateTime.now())
                        .build();
        when(profileRepository.save(profileModel)).thenReturn(createdProfile);
        profileModel = profileService.createProfile(profileModel);
        assertThat(profileModel).isNotNull();
        assertThat(profileModel.getModified()).isNotNull();
        assertThat(profileModel.getUserId()).isEqualTo("toto");
    }
}
