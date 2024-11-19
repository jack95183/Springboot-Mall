package com.jacky.spingbootmall.service.impl;

import com.jacky.spingbootmall.dao.ProductDao;
import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;
import com.jacky.spingbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(int productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(int productId) {
        productDao.deleteProductById(productId);
    }
}
