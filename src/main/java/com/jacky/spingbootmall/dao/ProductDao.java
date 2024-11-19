package com.jacky.spingbootmall.dao;

import com.jacky.spingbootmall.model.Product;

public interface ProductDao {

    Product getProductById(int productId);
}
