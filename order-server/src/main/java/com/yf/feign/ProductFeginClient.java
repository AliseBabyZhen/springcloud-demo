package com.yf.feign;

import com.yf.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @PROJECT_NAME: springcloud-demo
 * @DESCRIPTION: 只需在这个接口上配置的注解中加入要访问的是哪个服务
 * 再拼接上@RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
 * 其实就是将product-server/product/{id}的请求映射到了这里 可以视作一个controller
 * @USER:
 * @DATE: 2021/8/22 下午9:16
 */
@FeignClient(name="product-server")
public interface ProductFeginClient {
    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id);
}
