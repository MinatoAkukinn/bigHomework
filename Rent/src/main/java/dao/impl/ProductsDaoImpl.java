package dao.impl;

import dao.ProductsDao;
import domain.Products;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.util.List;

public class ProductsDaoImpl implements ProductsDao {
    @Override
    public List<Products> findNew() throws Exception {
        //最新列表
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from Object order by objectID desc limit 9";
        return qr.query(sql,new BeanListHandler<>(Products.class));

    }

    @Override
    public Products getById(String objectId) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from Object where ObjectID = ?";
        return qr.query(sql,new BeanHandler<>(Products.class),objectId);

    }
}
