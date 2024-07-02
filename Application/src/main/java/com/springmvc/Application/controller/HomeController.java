package com.springmvc.Application.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Application.Service.UserService;
import com.springmvc.Application.UserBean.EmployeeBean;
import com.springmvc.Application.UserBean.UserBean;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	ModelAndView mod=new ModelAndView();

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayUser(UserBean userbean)
	{
		ModelAndView model=new ModelAndView("login");
		model.addObject("loginBean",userbean);
		return model;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeUser(HttpServletRequest request,@ModelAttribute("loginBean")UserBean userbean)
	{
		ModelAndView model=null;
		UserBean user=new UserBean();
		
		try {
			boolean isValidUser=userService.isValidUser(userbean);
			if(isValidUser)
			{
				System.out.println("Login Successful");
				user=userService.isValidProfile(userbean.getEmail());
				if(user!=null) {
				model=new ModelAndView("welcome");
				
				model.addObject("userBean", user);
				
				request.setAttribute("loggedInUser",userbean.getEmail());
				
				}
				else {
					model=new ModelAndView("welcome");
					model.addObject("message", "No Data available to display");
				}
			}
			else
			{
				model=new ModelAndView("login");
				request.setAttribute("message","Invalid Credentials!!");
			}
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		return model;
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView displayRegister(UserBean userbean)
	{
		ModelAndView model=new ModelAndView("register");
		model.addObject("registerBean",userbean);
		return model;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView executeRegister(HttpServletRequest request,@ModelAttribute("registerBean")UserBean userbean)
	{
		ModelAndView model=null;
		try
		{
			boolean isRegister=userService.isRegister(userbean);
			if(isRegister)
			{
				model=new ModelAndView("login");
				model.addObject("loginBean",userbean);
				request.setAttribute("message", "User Register Successful!!");
				System.out.println("User Register Successful");
			}
			else
			{
				model=new ModelAndView("register");
				request.setAttribute("message", "Invalid Credentials!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace()
;		}
		
		return model;
		
	}
	
	@RequestMapping(value="/forgetPassword",method=RequestMethod.GET)
	public ModelAndView displayForgetPassword(UserBean userbean)
	{
		ModelAndView model=new ModelAndView("forgetPassword");
		model.addObject("forgotpasswordBean",userbean);
		return model;
	}
	
	@RequestMapping(value="/forgetPassword",method=RequestMethod.POST)
	public ModelAndView executeForgetPassword(HttpServletRequest request,@ModelAttribute("forgotpasswordBean")UserBean userbean)
	{
		ModelAndView model=null;
		try {
			if(userbean.getNewPassword().equals(userbean.getConfirmPassword()))
			{
				boolean isPassword=userService.isPassword(userbean);
				if(isPassword)
				{
					model=new ModelAndView("login");
					model.addObject("loginBean",userbean);
					request.setAttribute("message", "Password Updated Successfully!!");
					System.out.println("Password Updated Successfully!!");
				}
				else
				{

					model=new ModelAndView("forgetPassword");
					request.setAttribute("message", "Invalid Credentials!!");
				}
			}
			else
			{

				model=new ModelAndView("forgetPassword");
				request.setAttribute("message", "Invalid Credentials!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public ModelAndView displayProfile(HttpServletRequest request,@RequestParam("emailId")String email)
	{
		ModelAndView model=new ModelAndView();
		UserBean userDetails;
		try {
			userDetails=userService.isValidProfile(email);
			if(userDetails!=null)
			{
				
					model=new ModelAndView("profile");
					model.addObject("profileBean", userDetails);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/editProfile",method=RequestMethod.GET)
	public ModelAndView displayeditProfile(HttpServletRequest request,@RequestParam("emailId")String email,UserBean userbean)
	{
		ModelAndView model=new ModelAndView();
		
		try {
			UserBean userDetails=userService.isValidProfile(email);
			if(userDetails!=null)
			{
				
					model=new ModelAndView("editProfile");
					model.addObject("editBean", userDetails);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/editProfile",method=RequestMethod.POST)
	public ModelAndView executeeditProfile(HttpServletRequest request,@ModelAttribute("editBean")UserBean userbean)
	{
		ModelAndView model=null;
		try {
			boolean isEdit=userService.iseditProfile(userbean);
			if(isEdit)
			{
				model=new ModelAndView("profile");
				model.addObject("profileBean",userbean);
				request.setAttribute("message", "Profile updated successfully!!");
			}else {
				model=new ModelAndView("editProfile");
				model.addObject("editBean",userbean);

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/empLogin",method=RequestMethod.GET)
	public ModelAndView displayEmpLogin(UserBean userBean)
	{
		 ModelAndView model=new ModelAndView("empLogin");
		 model.addObject("empBean",userBean);
		 return model;
	}
	
	@RequestMapping(value="/empLogin",method=RequestMethod.POST)
	public ModelAndView executeEmpLogin(HttpServletRequest request,@ModelAttribute("empBean")UserBean userbean)
	{
		ModelAndView model=null;
		try {
			boolean isValidEmp=userService.isValidEmp(userbean);
			if(isValidEmp)
			{
				List<UserBean> data = userService.isValidEmpdisplay(userbean);
				if(data!=null)
				{
					model=new ModelAndView("table");
					model.addObject("result",data);
					request.setAttribute("message", "Vanakkam da mapla!!");
				}
				else {
				model=new ModelAndView("empLogin");
				request.setAttribute("message", "Invalid Credentials!!");}
			}
			else
			{
				model=new ModelAndView("empLogin");
				model.addObject("empBean",userbean);
				request.setAttribute("message", "Invalid Credentials!!");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/allowance",method=RequestMethod.GET)
	public ModelAndView displayAllowance(EmployeeBean empbean)
	{
		 ModelAndView model=new ModelAndView("allowance");
		 model.addObject("allowanceBean",empbean);
		 return model;
	}
	
	@RequestMapping(value="/allowance",method=RequestMethod.POST)
	public ModelAndView executeAllowance(HttpServletRequest request,@ModelAttribute("allowanceBean")EmployeeBean empbean)
	{
		ModelAndView model=null;
		try
		{
			boolean isValidAllowance=userService.isValidAllowance(empbean);
			if(isValidAllowance)
			{
				model=new ModelAndView("allallowance");
				model.addObject("allallowanceBean", empbean);
				request.setAttribute("message", "Allowance Table updated Successfully!!");
			}
			else
			{
				model=new ModelAndView("allowance");
				request.setAttribute("message", "Invalid credentials!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
		
	}
	
	@RequestMapping(value="/allallowance",method=RequestMethod.GET)
	public ModelAndView displayAllAllowance(UserBean userBean)
	{
		 ModelAndView model=new ModelAndView("allallowance");
		 model.addObject("allallowanceBean",userBean);
		 return model;
	}
	
	@RequestMapping(value="/allallowance",method=RequestMethod.POST)
	public String executeAllAllowance(HttpServletRequest request,@ModelAttribute("allallowanceBean")UserBean userBean,Model model ) throws SQLException
	{
		UserBean result=userService.empSalary(userBean.getEmpId());
		if(result!=null)
		{
			model.addAttribute("pag",result);
			
			return "singleEmployee";
		}
		else
		{
			model.addAttribute("message","Invalid Credentials!!");
			return "allallowance";
		}
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ModelAndView displayAll(UserBean userbean)throws SQLException
	{
		ModelAndView model=null;
		try {
		List<UserBean> data = userService.employeeData();
		if(data!=null)
		{
			model=new ModelAndView("all");
			model.addObject("alldata",data);
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
}
