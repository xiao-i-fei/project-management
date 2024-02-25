package com.xiaofei.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author xiaofei
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjectManagement {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ProjectManagement.class, args);
    }
}
