package com.wly.shortlinkStudy.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.wly.shortlinkStudy.admin.remote")
@MapperScan("com.wly.shortlinkStudy.admin.dao.mapper")
public class ShortLinkStudyAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortLinkStudyAdminApplication.class);
    }
}
