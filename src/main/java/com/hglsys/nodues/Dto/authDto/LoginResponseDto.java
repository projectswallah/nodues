package com.hglsys.nodues.Dto.authDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LoginResponseDto {


    private boolean success;
    private String message;

    private String token;
    private String role;
    private String username;
    private String tokenType;


}
