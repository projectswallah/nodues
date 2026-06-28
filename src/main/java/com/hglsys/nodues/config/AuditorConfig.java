package com.hglsys.nodues.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Configuration
public class AuditorConfig {


    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            Authentication auth =
                    SecurityContextHolder.getContext().getAuthentication();

            if (auth == null || !auth.isAuthenticated()) {
                return Optional.empty();
            }

            UserDetails user =
                    (UserDetails) auth.getPrincipal();

            return Optional.of(user.getUsername());
        };
    }


}
