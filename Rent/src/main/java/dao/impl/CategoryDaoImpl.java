package dao.impl;

import dao.CategoryDao;
import domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import service.CategoryService;
import utils.DataSourceUtils;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> finAll() throws Exception {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from category";
        return queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
    }
}
