package com.example.springjwt.service;

import com.example.springjwt.dto.ProfileUpdateDTO;
import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final UserRepository userRepository;

    public void updateProfile(ProfileUpdateDTO updateDTO, String username) {
        userRepository.updateProfile(
                updateDTO.getProfileImage(),
                updateDTO.getEmail(),
                updateDTO.getPhone(),
                updateDTO.getIntroduction(),
                username
        );
    }

    public UserEntity getProfile(String username) {
        return userRepository.findByUsername(username);
    }
}