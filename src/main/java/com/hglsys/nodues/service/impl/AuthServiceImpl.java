package com.hglsys.nodues.service.impl;

import com.hglsys.nodues.Dto.authDto.LoginRequestDto;
import com.hglsys.nodues.Dto.authDto.LoginResponseDto;
import com.hglsys.nodues.entities.BlacklistedToken;
import com.hglsys.nodues.entities.User;
import com.hglsys.nodues.repo.BlacklistedTokenRepository;
import com.hglsys.nodues.repo.UserRepo;
import com.hglsys.nodues.security.JwtService;
import com.hglsys.nodues.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;
    private final BlacklistedTokenRepository blacklistedTokenRepository;
    private final JwtService jwtService;

    @Override
    @Transactional
    public LoginResponseDto login(LoginRequestDto requestDto) {

        Optional<User> userOptional = userRepo.findByUsername(requestDto.getUsername());

        if(userOptional.isEmpty()){
            return LoginResponseDto.builder()
                    .success(false)
                    .message("Invalid username password")
                    .build();
        }

        User user = userOptional.get();

        if(!requestDto.getPassword().equals(user.getPassword())){
            return LoginResponseDto.builder()
                    .success(false)
                    .message("Invalid username password")
                    .build();
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().getRoleCode())
                .disabled(!user.getIsEnabled())
                .build();

        String token = jwtService.generateToken(userDetails);


        return LoginResponseDto.builder()
                .success(true)
                .message("Login successful")
                .token(token)
                .role(user.getRole().getRoleCode())
                .username(user.getUsername())
                .tokenType("Bearer")
                .build();
    }

    @Override
    public String logout(String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Invalid token");
        }

        String token = authHeader.substring(7);

        BlacklistedToken blacklistedToken = BlacklistedToken.builder()
                .token(token)
                .expiryDate(LocalDateTime.now().plusDays(1))
                .build();

        blacklistedTokenRepository.save(blacklistedToken);

        return "Logged out successfully";
    }
}
