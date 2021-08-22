package com.yf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 第一步 加上fegin的注解
 * 第二步 创建一个接口（可以理解为controller）处理映射过来的调用服务的http请求
 * 第三部 在controller中注入ProductFeginClient 然后调用相应的API即可
 * 对于负载均衡无需做配置 Ribbon默认的轮询 fegin也可使用 可以进行配置替换
 */
@SpringBootApplication
@EntityScan("con.yf.entity")
@EnableFeignClients
public class OrderApplication {

	/**
	 * 使用spring提供的RestTemplate发送http请求到商品服务
	 *      1.创建RestTemplate对象交给容器管理
	 *      2.在使用的时候,调用其方法完成操作 (getXX,postxxx)
	 * * @LoadBalanced : 是ribbon提供的负载均衡的注解
	 */
	@LoadBalanced  //使用这个注解默认开启了负载均衡 只需多启动几个服务即可，无需其他配置
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class,args);
	}
}
