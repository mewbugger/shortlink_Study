package com.wly.shortlinkStudy.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wly.shortlinkStudy.project.dao.mapper")
public class ShortLinkStudyProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkStudyProjectApplication.class);
    }
}
