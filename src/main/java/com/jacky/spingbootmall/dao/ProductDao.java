package com.jacky.spingbootmall.dao;
import java.util.List;
import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;

public interface ProductDao {

    List<Product> getProducts();
    Product getProductById(int productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(int productId, ProductRequest productRequest);
    void deleteProductById(int productId);
}
