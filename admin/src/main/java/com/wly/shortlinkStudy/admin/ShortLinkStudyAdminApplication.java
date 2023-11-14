package com.wly.shortlinkStudy.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wly.shortlinkStudy.admin.dao.mapper")
public class ShortLinkStudyAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortLinkStudyAdminApplication.class);
    }
}
