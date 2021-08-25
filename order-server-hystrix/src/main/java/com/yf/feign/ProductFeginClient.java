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
 * 这里相当于一个自定的API 调用这个方法就会发起这个对product-server的http请求
 * productserver那边controller收到请求进行处理然后返回数据给到这个边
 *
 * Feign集成了Ribbon
 * Feign利用了Ribbon维护了服务列表信息，并且通过轮询的方式实现了客户端的负载均衡，而与Ribbon不同的是，
 * 通过Feign只需要定义服务绑定接口且以声明式的方法，更加简单的实现了服务的调用
 *
 * 在调用那边的删除服务时 忘了要注意返回类型，那边返回了一个OK 方法要定义成String 。。
 * @USER:
 * @DATE: 2021/8/22 下午9:16
 */
@FeignClient(name="product-server",
        fallback = ProductFeginClientCallBack.class)
public interface ProductFeginClient {
    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/product/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id);
}
