package com.jacky.spingbootmall.service;

import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;

public interface ProductService {
    Product getProductById(int productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProductById(int productId);
}
