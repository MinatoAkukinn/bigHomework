package dao;

import domain.Products;

import java.util.List;

public interface ProductsDao {
    List<Products> findNew() throws Exception;

    Products getById(String objectId) throws Exception;
}
