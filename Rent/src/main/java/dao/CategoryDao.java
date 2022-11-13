package dao;

import domain.Category;
import service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> finAll() throws Exception;
}
