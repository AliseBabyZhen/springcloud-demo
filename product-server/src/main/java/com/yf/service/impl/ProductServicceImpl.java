package com.yf.service.impl;

import com.yf.dao.ProductDao;
import com.yf.pojo.Product;
import com.yf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PROJECT_NAME: springcloud-demo
 * @DESCRIPTION:
 * @USER:
 * @DATE: 2021/8/21 下午6:24
 */
@Service
public class ProductServicceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Override
    public Product finyById(long id) {
        return productDao.findById(id).get();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(long id) {
        productDao.deleteById(id);
    }
}
