package service;

import domain.Products;

import java.util.List;

public interface ProductsService {
    List<Products> findNew() throws Exception;

    Products getById(String objectId) throws Exception;
}
