package com.hglsys.nodues;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j                          // Logger
@SpringBootApplication
@EnableJpaAuditing
public class NoDuesApp {

    public static void main(String[] args) {
        SpringApplication.run(NoDuesApp.class, args);
        log.info("--======== No-Dues Application started =======--");
    }

}
