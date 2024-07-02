package com.springmvc.Application.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.springmvc.Application.Dao.UserDao;
import com.springmvc.Application.Service.UserService;
import com.springmvc.Application.UserBean.EmployeeBean;
import com.springmvc.Application.UserBean.UserBean;

public class UserServiceImpl implements UserService {
	
	private UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	@Override
	public boolean isValidUser(UserBean userbean) throws SQLException
	{
		return userdao.isValidUser(userbean);
	}
	
	@Override
	public boolean isRegister(UserBean userbean) throws SQLException
	{
		return userdao.isRegister(userbean);
	}
	
	@Override
	public boolean isPassword(UserBean userbean) throws SQLException
	{
		return userdao.isPassword(userbean);
	}
	
	@Override
	public UserBean isValidProfile(String email) throws SQLException
	{
		return userdao.isValidProfile(email);
	}

	@Override
	public boolean iseditProfile(UserBean userbean) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.iseditProfile(userbean);
	}
	
	@Override
	public boolean isValidEmp(UserBean userbean) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.isValidEmp(userbean);
	}

	@Override
	public List<UserBean> isValidEmpdisplay(UserBean userbean) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.isValidEmpdisplay(userbean);
	}

	@Override
	public boolean isValidAllowance(EmployeeBean empbean) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.isValidAllowance(empbean);
	}

	@Override
	public UserBean empSalary(int empId) throws SQLException {
		EmployeeBean bean1=userdao.empAllowance(7);
		UserBean user=userdao.empSalary(empId);
		bean1.setBasicSalary((user.getEmpSalary() *bean1.getBasicSalary()/100));
		bean1.setHra(user.getEmpSalary()*bean1.getHra()/100);
		bean1.setHa(user.getEmpSalary() *bean1.getHa()/100);
		bean1.setDa(user.getEmpSalary()*bean1.getDa()/100);
		bean1.setPf(user.getEmpSalary()*bean1.getPf()/100);
		bean1.setPt(user.getEmpSalary()*bean1.getPt()/100);
		bean1.setTotalSalary(bean1.getHra()+bean1.getHa()+bean1.getDa()+bean1.getBasicSalary());
		bean1.setGss(bean1.getPf()+bean1.getPt());
		bean1.setNetSalary(bean1.getTotalSalary()-bean1.getGss());
		user.setEmpBean(bean1);
		return user;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserBean> employeeData() throws SQLException {
		// TODO Auto-generated method stub
		List<UserBean> input=userdao.employeeData();
		EmployeeBean bean1=userdao.empAllowance(7);
		List<UserBean> file=new ArrayList<UserBean>();
		for(UserBean bean:input)
		{
			bean1.setBasicSalary((bean.getEmpSalary() *bean1.getBasicSalary()/100));
			bean1.setHra(bean.getEmpSalary()*bean1.getHra()/100);
			bean1.setHa(bean.getEmpSalary() *bean1.getHa()/100);
			bean1.setDa(bean.getEmpSalary()*bean1.getDa()/100);
			bean1.setPf(bean.getEmpSalary()*bean1.getPf()/100);
			bean1.setPt(bean.getEmpSalary()*bean1.getPt()/100);
			bean1.setTotalSalary(bean1.getHra()+bean1.getHa()+bean1.getDa()+bean1.getBasicSalary());
			bean1.setGss(bean1.getPf()+bean1.getPt());
			bean1.setNetSalary(bean1.getTotalSalary()-bean1.getGss());
			bean.setEmpBean(bean1);
			file.add(bean);
		}
		input=file;
		return input;
			
		
	}
}
