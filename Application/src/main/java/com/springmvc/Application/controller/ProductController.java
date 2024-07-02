package com.springmvc.Application.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Application.Service.ProductService;
import com.springmvc.Application.UserBean.ProductBean;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/productList/{categoryId}",method=RequestMethod.GET)
	public ModelAndView displayProduct(ProductBean productBean,@PathVariable int categoryId)throws SQLException
	{
		ModelAndView model=null;
		try {
			List<ProductBean> pro=productService.productData(categoryId);
			if(pro!=null)
			{
				model=new ModelAndView("productList");
				model.addObject("productBean",pro);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping(value="/productDescription/{productId}",method=RequestMethod.GET)
	public ModelAndView displayProductDescription(ProductBean productBean,@PathVariable int productId)throws SQLException
	{
		ModelAndView model=null;
		try {
			ProductBean pro=productService.productDescription(productId);
			if(pro!=null)
			{
				model=new ModelAndView("productDescription");
				model.addObject("productBean",pro);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}

}
