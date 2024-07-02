package com.springmvc.Application.Dao;

import java.sql.SQLException;
import java.util.List;

import com.springmvc.Application.UserBean.ProductBean;

public interface ProductDao {

	public List<ProductBean> productData(int categoryId)throws SQLException;

	public ProductBean productDescription(int productId)throws SQLException;

	

}
