package com.yf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yf.entity.Product;
import com.yf.feign.ProductFeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	//注入restTemplate对象
	//@Autowired
	//private RestTemplate restTemplate;

	@Autowired
	private ProductFeginClient productFeginClient;


	/**
	 * 基于ribbon的形式调用远程微服务
	 *  1.使用@LoadBalanced声明RestTemplate
	 *  2.使用服务名称替换ip地址
	 */
	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		//fegin简化调用请求
		return productFeginClient.findById(id);
	}


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable long id){
		return productFeginClient.delete(id);
	}

	/**
	 * 参数:商品id
	 *  通过订单系统,调用商品服务根据id查询商品信息
	 *      1.需要配置商品对象
	 *      2.需要调用商品服务
	 *  使用java中的urlconnection,httpclient,okhttp
	 */
/*	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		//调用discoveryClient方法
		//已调用服务名称获取所有的元数据
		List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT-SERVER");
		ServiceInstance serviceInstance = instances.get(0);


		Product product = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/"+id+"/",Product.class);
		return product;
	}*/


}
