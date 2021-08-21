package com.yf.controller;

import com.yf.entity.Product;
import com.yf.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

	//注入restTemplate对象
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 注入DiscoveryClient :
	 *  springcloud提供的获取原数组的工具类
	 *      调用方法获取服务的元数据信息
	 *
	 */
	@Autowired
	private DiscoveryClient discoveryClient;


	/**
	 * 基于ribbon的形式调用远程微服务
	 *  1.使用@LoadBalanced声明RestTemplate
	 *  2.使用服务名称替换ip地址
	 */
	/*@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		Product product = null;
		product = restTemplate.getForObject("http://localhost:9001/product/1",Product.class);
		return product;
	}*/

	/**
	 * 参数:商品id
	 *  通过订单系统,调用商品服务根据id查询商品信息
	 *      1.需要配置商品对象
	 *      2.需要调用商品服务
	 *  使用java中的urlconnection,httpclient,okhttp
	 */
	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		//调用discoveryClient方法
		//已调用服务名称获取所有的元数据
		List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT-SERVER");
		ServiceInstance serviceInstance = instances.get(0);


		Product product = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/"+id+"/",Product.class);
		return product;
	}


}
