package com.springmvc.Application.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.web.multipart.MultipartFile;

import com.springmvc.Application.Dao.UserDao;
import com.springmvc.Application.UserBean.EmployeeBean;
import com.springmvc.Application.UserBean.UserBean;

public class UserDaoImpl implements UserDao {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean isValidUser(UserBean userbean) throws SQLException {
		String query = "Select * from user where email=? and password=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userbean.getEmail());
		pstmt.setString(2, userbean.getPassword());
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return (resultSet.getInt(1) > 0);
		else
			return false;
	}

	@Override
	public boolean isRegister(UserBean userbean) throws SQLException {
		byte[] imageBytes = null;

		try {
			imageBytes = userbean.getImage().getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "INSERT INTO user(`username`,`password`,`email`,`phoneno`,`image`)values(?,?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userbean.getUsername());
		pstmt.setString(2, userbean.getPassword());
		pstmt.setString(3, userbean.getEmail());
		pstmt.setInt(4, userbean.getPhoneno());
		pstmt.setBytes(5, imageBytes);

		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isPassword(UserBean userBean) throws SQLException {
		String query = "Update user set password=? where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userBean.getNewPassword());
		pstmt.setString(2, userBean.getEmail());
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserBean isValidProfile(String email) throws SQLException {
		String query = "Select * from user where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {
			UserBean userbean = new UserBean();
			userbean.setUsername(result.getString("username"));
			userbean.setPassword(result.getString("password"));
			userbean.setEmail(result.getString("email"));
			userbean.setPhoneno(result.getInt("phoneno"));
			byte[] img = result.getBytes("image");
			String photo = Base64.getEncoder().encodeToString(img);
			userbean.setPic(photo);
			return userbean;
		}
		return null;
	}

	@Override
	public boolean iseditProfile(UserBean userbean) throws SQLException {
		// TODO Auto-generated method stub
		byte[] imageBytes = null;

		try {
			imageBytes = userbean.getImage().getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String query="Update user set username=?,password=?,phoneno=?,image=? where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1,userbean.getUsername());
		pstmt.setString(2, userbean.getPassword());
		pstmt.setInt(3, userbean.getPhoneno());
		pstmt.setBytes(4, imageBytes);
		pstmt.setString(5, userbean.getEmail());
				int res= pstmt.executeUpdate();
		if(res>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isValidEmp(UserBean userbean) throws SQLException {
		String query = "INSERT INTO employee(`cmpId`,`empId`,`empName`,`empSalary`)values(?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, userbean.getCmpId());
		pstmt.setInt(2, userbean.getEmpId());
		pstmt.setString(3, userbean.getEmpName());
		pstmt.setDouble(4, userbean.getEmpSalary());
		
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<UserBean> isValidEmpdisplay(UserBean userbean) throws SQLException {
		String query = "select * from employee";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet result = pstmt.executeQuery();
		List<UserBean> data= new ArrayList<UserBean>();
		while (result.next()) {
			UserBean user=new UserBean();
		user.setCmpId(result.getInt("cmpId"));
		user.setEmpId(result.getInt("empId"));
		user.setEmpName(result.getString("empName"));
		user.setEmpSalary(result.getDouble("empSalary"));
		data.add(user);
		}
		return data;
	}

	@Override
	public boolean isValidAllowance(EmployeeBean empbean) throws SQLException {
		String query = "INSERT INTO allowance(`cmpId`,`hra`,`ha`,`da`,`pf`,`pt`)values(?,?,?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, empbean.getCmpId());
		pstmt.setDouble(2, empbean.getHra());
		pstmt.setDouble(3, empbean.getHa());
		pstmt.setDouble(4, empbean.getDa());
		pstmt.setDouble(5, empbean.getPf());
		pstmt.setDouble(6, empbean.getPt());
		int res = pstmt.executeUpdate();
		if (res > 0) {
			return true;
		} else {
			return false;
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public UserBean empSalary(int empId) throws SQLException {
		String query = "Select * from employee where empId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, empId);
		ResultSet result = pstmt.executeQuery();
		UserBean userbean = new UserBean();
		if(result.next())
		{
			userbean.setCmpId(result.getInt("cmpId"));
			userbean.setEmpId(result.getInt("empId"));
			userbean.setEmpName(result.getString("empName"));
			userbean.setEmpSalary(result.getDouble("empSalary"));
			
		}
		return userbean;
		
	}
	@Override
	public EmployeeBean empAllowance(int cmpId) throws SQLException 
	{
		String query = "Select * from allowance";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet result = pstmt.executeQuery();
		EmployeeBean user = new EmployeeBean();
		if(result.next())
		{
			user.setHra(result.getDouble("hra"));
			user.setHa(result.getDouble("ha"));
			user.setDa(result.getDouble("da"));
			user.setPf(result.getDouble("pf"));
			user.setPt(result.getDouble("pt"));
			user.setCmpId(result.getInt("cmpId"));
			user.setBasicSalary(result.getDouble("basicSalary"));
		}
		return user;
	}

	@Override
	public List<UserBean> employeeData() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from employee";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet result = pstmt.executeQuery();
		List<UserBean> data= new ArrayList<UserBean>();
		while (result.next()) {
			UserBean user=new UserBean();
		user.setCmpId(result.getInt("cmpId"));
		user.setEmpId(result.getInt("empId"));
		user.setEmpName(result.getString("empName"));
		user.setEmpSalary(result.getDouble("empSalary"));
		data.add(user);
		}
		return data;
	}

}
