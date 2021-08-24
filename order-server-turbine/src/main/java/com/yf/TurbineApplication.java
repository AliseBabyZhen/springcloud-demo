package com.yf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 第一步 加上fegin的注解
 * 第二步 创建一个接口 接口中写着调用服务的请求
 * 第三部 在controller中注入ProductFeginClient 然后调用相应的在controller中注入ProductFeginClient方法就会像服务提供者发起请求
 * 对于负载均衡无需做配置 Ribbon默认的轮询 fegin也可使用 可以进行配置替换
 * http://localhost:9006/hystrix 监控平台
 * http://localhost:9006/actuator/hystrix.stream 要监控的断点 端口号跟随服务端口
 */
@SpringBootApplication
@EnableTurbine //启动turbine
@EnableHystrixDashboard //启动hystrix
public class TurbineApplication {
	public static void main(String[] args) {

		SpringApplication.run(TurbineApplication.class,args);
	}
}
