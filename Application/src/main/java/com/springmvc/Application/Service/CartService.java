package com.springmvc.Application.Service;

import java.sql.SQLException;

import com.springmvc.Application.UserBean.CartEntryBean;
import com.springmvc.Application.UserBean.FormBean;

public interface CartService {

	public boolean addToCart(FormBean form)throws SQLException;

	public FormBean showCart(FormBean form)throws SQLException;

	public boolean deleteCart(CartEntryBean cartentry)throws SQLException;

	public boolean updateCart(CartEntryBean cartentry)throws SQLException;

	
}
