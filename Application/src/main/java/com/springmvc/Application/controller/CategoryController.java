package com.springmvc.Application.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Application.Service.CategoryService;
import com.springmvc.Application.UserBean.CategoryBean;
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/category",method=RequestMethod.GET)
	public ModelAndView categoryDisplay(CategoryBean categoryBean)throws SQLException
	{
		ModelAndView model=null;
		try {
			List<CategoryBean> cart=categoryService.categoryData();
			if(cart!=null)
			{
				model=new ModelAndView("category");
				model.addObject("categoryBean", cart);
			}
			else
			{
				model=new ModelAndView("error");
				model.addObject("categoryabc", "invalid");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/subcategory/{categoryId}",method=RequestMethod.GET)
	public ModelAndView subcategoryDisplay(CategoryBean categoryBean,@PathVariable int categoryId)throws SQLException
	{
		ModelAndView model=null;
		try {
			List<CategoryBean> cat=categoryService.subcategoryData(categoryId);
			if(cat!=null)
			{
				model=new ModelAndView("subcategory");
				model.addObject("categoryBean", cat);
			}
			else
			{
				model=new ModelAndView("error");
				model.addObject("categoryabc", "invalid");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping(value="/brand/{categoryId}",method=RequestMethod.GET)
	public ModelAndView brandDisplay(CategoryBean categoryBean,@PathVariable int categoryId)throws SQLException
	{
		ModelAndView model=null;
		try {
			List<CategoryBean> cat=categoryService.brandData(categoryId);
			if(cat!=null)
			{
				model=new ModelAndView("brand");
				model.addObject("categoryBean", cat);
			}
			else
			{
				model=new ModelAndView("error");
				model.addObject("categoryabc", "invalid");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
}
