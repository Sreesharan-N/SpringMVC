package com.springmvc.Application.ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.Application.Dao.CategoryDao;
import com.springmvc.Application.Service.CategoryService;
import com.springmvc.Application.UserBean.CategoryBean;

public class CategoryServiceImpl implements CategoryService{
    
	@Autowired
	private CategoryDao categorydao;

	
	
	public CategoryDao getCategorydao() {
		return categorydao;
	}



	public void setCategorydao(CategoryDao categorydao) {
		this.categorydao = categorydao;
	}



	@Override
	public List<CategoryBean> categoryData() throws SQLException
	{
		return  categorydao.categoryData();
	}



	@Override
	public List<CategoryBean> subcategoryData(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		return categorydao.subcategoryData(categoryId);
	}



	@Override
	public List<CategoryBean> brandData(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		return categorydao.brandData(categoryId);
	}
	
	
}
