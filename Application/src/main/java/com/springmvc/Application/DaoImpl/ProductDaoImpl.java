package com.springmvc.Application.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import com.springmvc.Application.Dao.ProductDao;
import com.springmvc.Application.UserBean.ProductBean;

public class ProductDaoImpl implements ProductDao  {
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<ProductBean> productData(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		String query="Select * from product  where categoryId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, categoryId);
		List<ProductBean> data=new ArrayList<ProductBean>();
		ResultSet result = pstmt.executeQuery();
		
		while(result.next())
		{
			ProductBean bean=new ProductBean();
			bean.setProductName(result.getString("productName"));
			bean.setColor(result.getString("color"));
			bean.setPrice(result.getDouble("price"));
			bean.setProductId(result.getInt("productId"));
			byte[] img=result.getBytes("image");
			String photo=Base64.getEncoder().encodeToString(img);
			bean.setPic(photo);
			data.add(bean);
		}
		return data;
	}

	@Override
	public ProductBean productDescription(int productId) throws SQLException {
		// TODO Auto-generated method stub
		String query="Select * from product  where productId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, productId);
		ProductBean bean=new ProductBean();
		ResultSet result = pstmt.executeQuery();
		
		if(result.next())
		{
			
			bean.setProductName(result.getString("productName"));
			bean.setColor(result.getString("color"));
			bean.setProductId(result.getInt("productId"));
			bean.setPrice(result.getDouble("price"));
			byte[] img=result.getBytes("image");
			String photo=Base64.getEncoder().encodeToString(img);
			bean.setPic(photo);
			bean.setDetails(result.getString("details"));
			bean.setFeatures(result.getString("features"));
			bean.setModel(result.getString("model"));
			
			
		}
		return bean;
	}

}
