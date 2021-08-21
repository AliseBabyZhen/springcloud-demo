package com.yf.service;

import com.yf.pojo.Product;

/**
 * @PROJECT_NAME: springcloud-demo
 * @DESCRIPTION:
 * @USER:
 * @DATE: 2021/8/21 下午5:52
 */

public interface ProductService {

    Product finyById(long id);
    void update(Product product);
    void save(Product product);
    void delete(long id);
}
