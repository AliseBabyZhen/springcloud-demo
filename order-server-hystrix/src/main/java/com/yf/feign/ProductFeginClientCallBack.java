package com.yf.feign;

import com.yf.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: workspace
 * @DESCRIPTION:
 * @USER:
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
