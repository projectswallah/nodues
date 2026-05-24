package com.hglsys.nodues;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j                          // Logger
@SpringBootApplication
public class NoDuesBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoDuesBackendApplication.class, args);
        log.info("--======== No-Dues Application started =======--");
    }

}
