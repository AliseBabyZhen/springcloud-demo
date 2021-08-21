package com.yf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @PROJECT_NAME: springcloud-demo
 * @DESCRIPTION:
 * @USER:
 * @DATE: 2021/8/21 下午5:57
 */

@SpringBootApplication
@EntityScan("com.yf.pojo")
@EnableEurekaClient
public class ProducatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducatApplication.class,args);
    }
}
