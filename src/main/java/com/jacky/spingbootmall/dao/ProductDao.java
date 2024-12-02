package com.jacky.spingbootmall.dao;

import com.jacky.spingbootmall.dto.ProductQueryParams;
import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);
    Page<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(int productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(int productId, ProductRequest productRequest);
    void updateStock(int productId, int stock);
    void deleteProductById(int productId);
}
