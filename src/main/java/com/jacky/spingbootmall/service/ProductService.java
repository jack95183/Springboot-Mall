package com.jacky.spingbootmall.service;
import java.util.List;
import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(int productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProductById(int productId);
}
