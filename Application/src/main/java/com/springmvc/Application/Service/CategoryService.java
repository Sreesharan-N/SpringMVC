package com.springmvc.Application.Service;

import java.sql.SQLException;
import java.util.List;

import com.springmvc.Application.UserBean.CategoryBean;

public interface CategoryService {


	public List<CategoryBean> categoryData() throws SQLException;

	public List<CategoryBean> subcategoryData(int categoryId)throws SQLException;

	public List<CategoryBean> brandData(int categoryId) throws SQLException;

}
