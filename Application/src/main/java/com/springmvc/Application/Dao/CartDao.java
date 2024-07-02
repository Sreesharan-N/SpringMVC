package com.springmvc.Application.Dao;

import java.sql.SQLException;
import java.util.List;

import com.springmvc.Application.UserBean.CartBean;
import com.springmvc.Application.UserBean.CartEntryBean;
import com.springmvc.Application.UserBean.ProductBean;



public interface CartDao {


	public boolean createCart(String email, int totalQuantity, double subToatl) throws SQLException;
	
	public boolean createCartEntry(CartEntryBean cartEntry,CartBean cartBean) throws SQLException;
	
	public CartBean getCart(String email)throws SQLException;
	
	public List<CartEntryBean> getCartEntry(int cartId)throws SQLException;
	
	public CartEntryBean  cartEntryExist(int cartId,int productId) throws SQLException;
	
	public boolean updateCartEntry(CartEntryBean cartEntry) throws SQLException;
	
	public List<CartEntryBean> cartEntries(int cartId)throws SQLException;
	
	public boolean updateCart(int cartId,int totalQuantity,double subTotal)throws SQLException;
	
	public ProductBean cartEntry(int productId)throws SQLException;
	
	public boolean updateShowCart(CartEntryBean x)throws SQLException;

	public boolean deleteCart(CartEntryBean cartentry)throws SQLException;

	public boolean updateCart(CartEntryBean cartentry)throws SQLException;

}
