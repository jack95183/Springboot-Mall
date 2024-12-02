package com.jacky.spingbootmall.dao.impl;

// JPA 分頁和排序相關的類別
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

// Spring Data JPA 中的 Repository 類別
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// Java 的核心類別
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

// 自訂的類別
import com.jacky.spingbootmall.dao.ProductDao;
import com.jacky.spingbootmall.dto.ProductQueryParams;
import com.jacky.spingbootmall.dto.ProductRequest;
import com.jacky.spingbootmall.model.Product;
import com.jacky.spingbootmall.model.Repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        Iterable<Product> productsIterable = productRepository.findAll();
        List<Product> productsList = StreamSupport.stream(productsIterable.spliterator(), false)
                                          .collect(Collectors.toList());
        return productsList.size();
    }

    @Override
    public Page<Product> getProducts(ProductQueryParams params) {
        Sort sort = Sort.by(params.getOrderBy().equals("price") ? "price" : "createdDate");
        sort = params.getSort().equalsIgnoreCase("desc") ? sort.descending() : sort.ascending();
        Pageable pageable = PageRequest.of(params.getOffset(), params.getLimit(), sort);
        
        return productRepository.findProducts(params.getCategory(), params.getSearch(), pageable);
    }

    @Override
    public Product getProductById(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setCategory(productRequest.getcategory());
        product.setImage_url(productRequest.getimageUrl());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setDescription(productRequest.getDescription());
        product.setCreatedDate(new Date());
        product.setLastModifiedDate(new Date());

        // Save the product and return the generated ID
        return productRepository.save(product).getProductId();
    }

    @Override
    public void updateProduct(int productId, ProductRequest productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProductName(productRequest.getProductName());
            product.setCategory(productRequest.getcategory());
            product.setImage_url(productRequest.getimageUrl());
            product.setPrice(productRequest.getPrice());
            product.setStock(productRequest.getStock());
            product.setDescription(productRequest.getDescription());
            product.setLastModifiedDate(new Date());

            productRepository.save(product);
        }
    }

    @Override
    public void updateStock(int productId, int stock) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setStock(stock);
            product.setLastModifiedDate(new Date());
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}
