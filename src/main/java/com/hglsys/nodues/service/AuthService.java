package com.hglsys.nodues.service;

import com.hglsys.nodues.Dto.authDto.LoginRequestDto;
import com.hglsys.nodues.Dto.authDto.LoginResponseDto;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto requestDto);

    String logout(String authHeader);
}
