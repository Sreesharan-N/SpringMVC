package com.springmvc.Application.ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.springmvc.Application.Dao.ProductDao;
import com.springmvc.Application.Service.ProductService;
import com.springmvc.Application.UserBean.ProductBean;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productdao;
	

	public ProductDao getProductdao() {
		return productdao;
	}


	public void setProductdao(ProductDao productdao) {
		this.productdao = productdao;
	}


	@Override
	public List<ProductBean> productData(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		return productdao.productData(categoryId);
	}


	@Override
	public ProductBean productDescription(int productId) throws SQLException {
		// TODO Auto-generated method stub
		return productdao.productDescription(productId);
	}

}
