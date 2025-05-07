package com.example.springjwt.controller;

import com.example.springjwt.dto.ProfileUpdateDTO;
import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;

    // 프로필 조회
    @GetMapping
    public ResponseEntity<UserEntity> getProfile(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(myPageService.getProfile(username));
    }

    // 프로필 수정
    @PutMapping("/update")
    public ResponseEntity<String> updateProfile(
            @RequestBody ProfileUpdateDTO updateDTO,
            Authentication authentication
    ) {
        String username = authentication.getName();
        myPageService.updateProfile(updateDTO, username);
        return ResponseEntity.ok("Profile updated");
    }
}