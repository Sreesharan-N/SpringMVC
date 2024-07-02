package com.springmvc.Application.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import com.springmvc.Application.Dao.CartDao;
import com.springmvc.Application.UserBean.CartBean;
import com.springmvc.Application.UserBean.CartEntryBean;
import com.springmvc.Application.UserBean.ProductBean;


public class CartDaoImpl implements CartDao{
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean createCart(String email,int totalQuantity,double subToatl) throws SQLException {
		
		String query="Insert into cart(`email`,`totalQuantity`,`subTotal`)values(?,?,?)";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setInt(2,totalQuantity);
		pstmt.setDouble(3, subToatl);
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} 
		else {
			return false;
		}
	}

	@Override
	public boolean createCartEntry(CartEntryBean cartEntry, CartBean cartBean) throws SQLException {
		// TODO Auto-generated method stub
		String query="Insert into cartentry(`cartId`,`productId`,`price`,`quantity`,`total`)values(?,?,?,?,?)";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartBean.getId());
		pstmt.setInt(2, cartEntry.getProductId());
		pstmt.setDouble(3, cartEntry.getPrice());
		pstmt.setInt(4, cartEntry.getQuantity());
		pstmt.setDouble(5, cartEntry.getTotal());
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} 
		else {
			return false;
		}
	}

	@Override
	public CartBean getCart(String email) throws SQLException {
		
		String query="Select * from cart where email=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet result=pstmt.executeQuery();
		CartBean items=new CartBean();
		if(result.next())
		{
			items.setId(result.getInt("id"));
			items.setEmail(result.getString("email"));
			items.setTotalQuantity(result.getInt("totalQuantity"));
			items.setSubTotal(result.getDouble("subTotal"));
		}
		return items;
		
	}

	@Override
	public List<CartEntryBean> getCartEntry(int cartId) throws SQLException {
		// TODO Auto-generated method stub
		String query="Select * from cartentry where cartId=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartId);
		ResultSet result=pstmt.executeQuery();
		List<CartEntryBean> bean=new ArrayList<CartEntryBean>();
		while(result.next())
		{
			CartEntryBean a=new CartEntryBean();
			a.setCartId(result.getInt("cartId"));
			a.setProductId(result.getInt("productId"));
			a.setPrice(result.getDouble("price"));
			a.setQuantity(result.getInt("quantity"));
			a.setTotal(result.getDouble("total"));
			bean.add(a);
		}
		return bean;
	}

	@Override
	public CartEntryBean cartEntryExist(int cartId, int productId) throws SQLException {
		
		String query="Select * from cartentry where cartId=? and productId=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartId);
		pstmt.setInt(2, productId);
		ResultSet result=pstmt.executeQuery();
		CartEntryBean a=new CartEntryBean();
		while(result.next())
		{
			a.setCartId(result.getInt("cartId"));
			a.setProductId(result.getInt("productId"));
			a.setPrice(result.getDouble("price"));
			a.setQuantity(result.getInt("quantity"));
			a.setTotal(result.getDouble("total"));
		}
		return a;
	}

	@Override
	public boolean updateCartEntry(CartEntryBean cartEntry) throws SQLException {
		// TODO Auto-generated method stub
		String query="update cartentry set quantity=?,total=? where cartId=? and productId=? ";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartEntry.getQuantity());
		pstmt.setDouble(2, cartEntry.getTotal());
		pstmt.setInt(3, cartEntry.getCartId());
		pstmt.setInt(4, cartEntry.getProductId());
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CartEntryBean> cartEntries(int cartId) throws SQLException {
		// TODO Auto-generated method stub
		String query="Select * from cartentry where cartId=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartId);
		ResultSet result=pstmt.executeQuery();
		List<CartEntryBean> bean=new ArrayList<CartEntryBean>();
		while(result.next())
		{
			CartEntryBean a=new CartEntryBean();
			a.setEntryId(result.getInt("entryId"));
			a.setCartId(result.getInt("cartId"));
			a.setProductId(result.getInt("productId"));
			a.setPrice(result.getDouble("price"));
			a.setQuantity(result.getInt("quantity"));
			a.setTotal(result.getDouble("total"));
			bean.add(a);
		}
		return bean;
	}

	@Override
	public boolean updateCart(int cartId, int totalQuantity, double subTotal)throws SQLException {
		// TODO Auto-generated method stub
		String query="update cart set totalQuantity=?,subTotal=? where id=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1,totalQuantity);
		pstmt.setDouble(2, subTotal);
		pstmt.setInt(3, cartId);
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ProductBean cartEntry(int productId) throws SQLException {
		String query="Select * from product  where productId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, productId);
		ProductBean bean=new ProductBean();
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			bean.setProductName(result.getString("productName"));
			bean.setColor(result.getString("color"));
			bean.setPrice(result.getDouble("price"));
			bean.setProductId(result.getInt("productId"));
			byte[] img=result.getBytes("image");
			String photo=Base64.getEncoder().encodeToString(img);
			bean.setPic(photo);
		}
		return bean;
	}

	@Override
	public boolean updateCart(CartEntryBean x) throws SQLException {
		String query="update cartentry set quantity=? where entryId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1,x.getQuantity());
		pstmt.setInt(2, x.getEntryId());
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deleteCart(CartEntryBean cartentry) throws SQLException {
		// TODO Auto-generated method stub
		String query="delete from cartentry where cartId=? and productId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartentry.getCartId());
		pstmt.setInt(2, cartentry.getProductId());	
		int res = pstmt.executeUpdate();
		if (res > 0) {
			CartBean cart=getCart("sreesharan23@gmail.com");
			int totalQuantity = 0;
			double subTotal=0;
			List<CartEntryBean> kart = cartEntries(cart.getId());
			for(CartEntryBean beans :kart) {
				totalQuantity += beans.getQuantity();
				beans.setTotal(beans.getPrice()*beans.getQuantity());
				subTotal += beans.getTotal();
				
			}
			boolean done = updateCart(cart.getId(),totalQuantity,subTotal);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateShowCart(CartEntryBean cartentry) throws SQLException {
		// TODO Auto-generated method stub
		String query="update cartentry set quantity=? where entryId=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartentry.getQuantity());
		pstmt.setInt(2, cartentry.getEntryId());	
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	

}
