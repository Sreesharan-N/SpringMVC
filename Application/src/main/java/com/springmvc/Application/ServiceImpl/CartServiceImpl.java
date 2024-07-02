package com.springmvc.Application.ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.Application.Dao.CartDao;
import com.springmvc.Application.Service.CartService;
import com.springmvc.Application.UserBean.CartBean;
import com.springmvc.Application.UserBean.CartEntryBean;
import com.springmvc.Application.UserBean.FormBean;
import com.springmvc.Application.UserBean.ProductBean;

public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartdao;

	public CartDao getCartdao() {
		return cartdao;
	}

	public void setCartdao(CartDao cartdao) {
		this.cartdao = cartdao;
	}
	String email="sreesharan23@gmail.com";

	@Override
	public boolean addToCart(FormBean form) throws SQLException {
		// TODO Auto-generated method stub
		int totalQuantity=0;
		double subTotal=0;
		
		CartBean cart=cartdao.getCart("sreesharan23@gmail.com");
		if(cart!=null && cart.getId()>0)
		{
			int id=cart.getId();
		}
		else
		{
			boolean kart=cartdao.createCart(email, totalQuantity, subTotal);
		}
		
		CartEntryBean cebean=cartdao.cartEntryExist(cart.getId(), form.getProductId());	
		if(cebean!=null && cebean.getQuantity()>0)
		{
			CartEntryBean entry=new CartEntryBean();
			entry.setCartId(cart.getId());
			entry.setProductId(cebean.getProductId());
			entry.setQuantity(form.getQuantity()+cebean.getQuantity());
			entry.setTotal(cebean.getPrice()*entry.getQuantity());
			boolean cart1 =cartdao.updateCartEntry(entry);
			boolean update=cartdao.updateCart(cart.getId(), totalQuantity, subTotal);
		}
		else
		{
			CartEntryBean entry=new CartEntryBean();
			entry.setCartId(cart.getId());
			entry.setProductId(form.getProductId());
			entry.setTotal(form.getQuantity()*form.getPrice());
			entry.setQuantity(form.getQuantity());
			entry.setPrice(form.getPrice());
			boolean cart2=cartdao.createCartEntry(entry, cart);
		}
		
		List<CartEntryBean> l=cartdao.cartEntries(cart.getId());
		for(CartEntryBean i:l)
		{
			subTotal+=i.getTotal();
			totalQuantity +=i.getQuantity();
		}
		boolean update=cartdao.updateCart(cart.getId(), totalQuantity, subTotal);
		List<CartEntryBean> li=cartdao.cartEntries(cart.getId());
		return true;
	}

	@Override
	public FormBean showCart(FormBean form) throws SQLException {
		
		CartBean cart=cartdao.getCart(email);
		form.setCartbean(cart);
		List<CartEntryBean> li=cartdao.cartEntries(cart.getId());
		for(CartEntryBean entry:li)
		{
			int productId=entry.getProductId();
			ProductBean pro=cartdao.cartEntry(productId);
			entry.setProduct(pro);
		}
		form.setCartentry(li);
		return form;
	}

	@Override
	public boolean deleteCart(CartEntryBean cartentry) throws SQLException {
		// TODO Auto-generated method stub
		return cartdao.deleteCart(cartentry);
	}

	@Override
	public boolean updateCart(CartEntryBean cartentry) throws SQLException {
		// TODO Auto-generated method stub
		return cartdao.updateCart(cartentry);
	}
	
	
	
}
