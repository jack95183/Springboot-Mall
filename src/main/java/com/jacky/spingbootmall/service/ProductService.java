package com.jacky.spingbootmall.service;

import com.jacky.spingbootmall.dto.ProductQueryParams;
import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ProductService {
    Integer countProduct(ProductQueryParams productQueryParams);
    Page<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(int productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProductById(int productId);
}
