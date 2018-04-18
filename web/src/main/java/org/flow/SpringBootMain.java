package org.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication    // 启动SpringBoot程序，而后自带子包扫描
@ServletComponentScan
@EnableTransactionManagement
public class SpringBootMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootMain.class, args);
    }
}
