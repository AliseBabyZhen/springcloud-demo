package com.yf.controller;

import com.yf.pojo.Product;
import com.yf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: springcloud-demo
 * @DESCRIPTION:
 * @USER:
 * @DATE: 2021/8/21 下午6:09
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Value("${server.port}")
    private String port;
    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product find(@PathVariable long id){
        Product product = productService.finyById(id);
        product.setProductName("访问的是"+ip+":"+port);
        return product;
    }
}
