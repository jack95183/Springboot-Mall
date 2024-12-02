package com.jacky.spingbootmall.model.Repository;

import com.jacky.spingbootmall.model.Product;
import com.jacky.spingbootmall.constant.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // 查找分類中的產品
    List<Product> findByCategory(ProductCategory category);

    @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category) " +
       "AND (:search IS NULL OR p.productName LIKE %:search% OR p.description LIKE %:search%)")
    Page<Product> findProducts(@Param("category") ProductCategory category,
                            @Param("search") String search,
                            Pageable pageable);
}