package com.springmvc.Application.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import com.springmvc.Application.Dao.CategoryDao;
import com.springmvc.Application.UserBean.CategoryBean;

public class CategoryDaoImpl implements CategoryDao {
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<CategoryBean> categoryData() throws SQLException {
		
		String query="Select * from category where parentId=0";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet result = pstmt.executeQuery();
		List<CategoryBean> data=new ArrayList<CategoryBean>();
		while(result.next())
		{
			CategoryBean categoryBean=new CategoryBean();
			categoryBean.setCategoryId(result.getInt("categoryId"));
			categoryBean.setCategoryName(result.getString("categoryName"));
			categoryBean.setParentId(result.getInt("parentId"));
			byte[] img = result.getBytes("image");
			String photo = Base64.getEncoder().encodeToString(img);
			categoryBean.setPic(photo);
			data.add(categoryBean);
		}
		return data;
	}

	@Override
	public List<CategoryBean> subcategoryData(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		String query="Select * from category where parentId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, categoryId);
		ResultSet result = pstmt.executeQuery();
		List<CategoryBean> data=new ArrayList<CategoryBean>();
		while(result.next())
		{
			CategoryBean categoryBean=new CategoryBean();
			categoryBean.setCategoryId(result.getInt("categoryId"));
			categoryBean.setCategoryName(result.getString("categoryName"));
			categoryBean.setParentId(result.getInt("parentId"));
			byte[] img = result.getBytes("image");
			String photo = Base64.getEncoder().encodeToString(img);
			categoryBean.setPic(photo);
			data.add(categoryBean);
		}
		return data;
	}

	@Override
	public List<CategoryBean> brandData(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		String query="Select * from category where parentId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, categoryId);
		ResultSet result = pstmt.executeQuery();
		List<CategoryBean> data=new ArrayList<CategoryBean>();
		while(result.next())
		{
			CategoryBean categoryBean=new CategoryBean();
			categoryBean.setCategoryId(result.getInt("categoryId"));
			categoryBean.setCategoryName(result.getString("categoryName"));
			categoryBean.setParentId(result.getInt("parentId"));
			byte[] img = result.getBytes("image");
			String photo = Base64.getEncoder().encodeToString(img);
			categoryBean.setPic(photo);
			data.add(categoryBean);
		}
		return data;
	}

}
