package service.impl;

import dao.ProductsDao;
import dao.impl.ProductsDaoImpl;
import domain.Products;
import service.ProductsService;

import java.util.List;

public class ProductsServiceImpl implements ProductsService {
    @Override
    public List<Products> findNew() throws Exception {
        ProductsDao pd=new ProductsDaoImpl();
        return pd.findNew();
    }

    @Override
    public Products getById(String objectId) throws Exception {
        ProductsDao pd=new ProductsDaoImpl();
        return pd.getById(objectId);

    }
}
