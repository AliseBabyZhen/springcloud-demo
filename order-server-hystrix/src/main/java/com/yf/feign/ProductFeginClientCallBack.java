package com.yf.feign;

import com.yf.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: workspace
 * @DESCRIPTION:
 * @USER:
 *     熔断器是当有一半的请求失败会触发熔断 然后所有的请求都会失败，但是这个时间默认是5s 然后会进入半打开状态
 *     这个时候会放一个请求通过 如果请求成功 则关闭断路器 否则继续熔断 然后重新5s计时。
 *     hystrix是aop原理  代理对象和被代理对象实现了相同的接口但有了不同的实现方式 jdk动态代理思路
 *
 * @DATE: 2021/8/23 下午5:27
 */
@Component
public class ProductFeginClientCallBack implements  ProductFeginClient {
    @Override
    public Product findById(Long id) {
        Product product = new Product(); product.setId(-1l);
        product.setProductName("熔断:触发降级方法");
        return product;
    }

    @Override
    public String delete(long id) {
        return "熔断:触发降级方法";
    }
}
