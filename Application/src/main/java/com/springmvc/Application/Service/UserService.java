package com.springmvc.Application.Service;

import java.sql.SQLException;
import java.util.List;

import com.springmvc.Application.UserBean.EmployeeBean;
import com.springmvc.Application.UserBean.UserBean;

public interface UserService {

	public boolean isValidUser(UserBean userbean) throws SQLException;

	public boolean isRegister(UserBean userbean) throws SQLException;

	public boolean isPassword(UserBean userbean) throws SQLException;

	public UserBean isValidProfile(String email)throws SQLException;

	public boolean iseditProfile(UserBean userbean)throws SQLException;

	public boolean isValidEmp(UserBean userbean)throws SQLException;
	
	public List<UserBean> isValidEmpdisplay(UserBean userbean) throws SQLException;

	public boolean isValidAllowance(EmployeeBean empbean) throws SQLException;

	public UserBean empSalary(int empId)throws SQLException;

	public List<UserBean> employeeData()throws SQLException;


	

}
