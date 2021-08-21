package com.yf.controller;

import com.yf.pojo.Product;
import com.yf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product find(@PathVariable long id){
        System.out.println("1111111111111111");
        return productService.finyById(id);
    }
}
