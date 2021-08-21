package com.yf.dao;

import com.yf.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @PROJECT_NAME: springcloud-demo
 * @DESCRIPTION:
 * @USER:
 * @DATE: 2021/8/21 下午6:07
 */
public interface ProductDao  extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {}