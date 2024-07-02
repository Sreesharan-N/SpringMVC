package com.springmvc.Application.UserBean;

import java.util.List;

public class FormBean {
	
	private int productId;
	
	private double price;
	
	private int quantity;
	
	private int cartId;
	
	private ProductBean product;
	
	private List<CartEntryBean> cartentry;
	
	private CartBean cartbean;
	

	public CartBean getCartbean() {
		return cartbean;
	}

	public void setCartbean(CartBean cartbean) {
		this.cartbean = cartbean;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	public List<CartEntryBean> getCartentry() {
		return cartentry;
	}

	public void setCartentry(List<CartEntryBean> cartentry) {
		this.cartentry = cartentry;
	}

	
}
