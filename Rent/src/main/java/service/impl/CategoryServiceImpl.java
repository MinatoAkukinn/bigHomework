package service.impl;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import service.CategoryService;
import utils.JsonUtil;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public String finALL() throws Exception {
        try {
            CategoryDao categoryDao=new CategoryDaoImpl();
           List<Category> list=categoryDao.finAll();
           if(list!=null&&list.size()>0){
               return JsonUtil.list2json(list);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
