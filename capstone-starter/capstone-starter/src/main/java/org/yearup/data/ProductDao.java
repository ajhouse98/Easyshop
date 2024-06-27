package org.yearup.data;

import org.yearup.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao
{
    List<Product> search(Integer category_Id, BigDecimal minPrice, BigDecimal maxPrice, String color);
    List<Product> listByCategory_Id(int category_Id);
    Product getById(int productId);
    Product create(Product product);
    void update(int productId, Product product);
    void delete(int productId);
}
