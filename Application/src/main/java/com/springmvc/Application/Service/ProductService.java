package com.springmvc.Application.Service;

import java.sql.SQLException;
import java.util.List;

import com.springmvc.Application.UserBean.ProductBean;

public interface ProductService {

	public List<ProductBean> productData(int categoryId)throws SQLException;

	public ProductBean productDescription(int productIdId)throws SQLException;

}