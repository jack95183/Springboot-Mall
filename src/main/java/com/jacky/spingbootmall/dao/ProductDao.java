package com.jacky.spingbootmall.dao;

import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;

public interface ProductDao {

    Product getProductById(int productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(int productId, ProductRequest productRequest);
}
