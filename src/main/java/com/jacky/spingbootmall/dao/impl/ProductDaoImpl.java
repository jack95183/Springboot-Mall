package com.jacky.spingbootmall.dao.impl;

import com.jacky.spingbootmall.dao.ProductDao;
import com.jacky.spingbootmall.model.Product;
import com.jacky.spingbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class  ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(int productId) {
        String sql = """
                        
                SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date
                        FROM product
                        WHERE product_id = :produceId
                         """;

        Map<String,Object> map = new HashMap<>();
        map.put("produceId", productId);
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(productList.size() > 0) {
            return productList.get(0);
        }else{
            return null;
        }
    }
}
