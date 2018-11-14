package com.sxit.CoolMeet.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxit.CoolMeet.Entity.Staff;

public class StaffDataBase extends BaseDao{
	public Staff selectByIdAndPwd(String username,String pwd) throws Exception
	{
		Staff staff=null;
		this.openConnection();
		String sql="select * from staff01 where username=? and pwd=? and staffstatus!=4";
		PreparedStatement pst= conn.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, pwd);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			staff=new Staff();
			staff.setStaffid(rs.getInt("staffid"));
			staff.setUsername(rs.getString("username"));
			staff.setStaffname(rs.getString("staffname"));
			staff.setPhone(rs.getString("phone"));
			staff.setEmail(rs.getString("email"));
			staff.setStatus(rs.getString("staffstatus"));
			staff.setDepartmentid(rs.getInt("departmentid"));
			staff.setRole(rs.getString("roles"));
			staff.setPwd(rs.getString("pwd"));
		}
		rs.close();
		pst.close();
		return staff;
	}
	/**
	 * 修改密码
	 * @param staffid
	 * @param newPwd
	 * @throws Exception
	 */
	public void changePwd(int staffid,String newPwd) throws Exception {
		this.openConnection();
		String sql="update staff01 set pwd=? where staffid=?";
		PreparedStatement pst= conn.prepareStatement(sql);
		pst.setString(1, newPwd);
		pst.setInt(2,staffid);
		pst.execute();
		pst.close();
	}
	public Staff selectByName(String username) throws Exception{
		Staff staff=null;
		this.openConnection();
		String sql="select * from staff01 where username=? and staffstatus!=4";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			staff=new Staff();
			staff.setStaffid(rs.getInt("staffid"));
			staff.setUsername(rs.getString("username"));
			staff.setStaffname(rs.getString("staffname"));
			staff.setPhone(rs.getString("phone"));
			staff.setEmail(rs.getString("email"));
			staff.setStatus(rs.getString("staffstatus"));
			staff.setDepartmentid(rs.getInt("departmentid"));
			staff.setRole(rs.getString("roles"));
			staff.setPwd(rs.getString("pwd"));
		}
		rs.close();
		pst.close();
		return staff;
	}
	/**
	 * 保存员工方法
	 * @param staffname
	 * @param username
	 * @param pwd
	 * @param phone
	 * @param email
	 * @param department
	 * @throws Exception
	 */
	
	public void saveStaff(String staffname,String username,String pwd,String phone,String email,int department) throws Exception {
		this.openConnection();
		String sql="insert into staff01(staffname,username,phone,email,staffstatus,departmentid,roles,pwd) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, staffname);
		pst.setString(2, username);
		pst.setString(3, phone);
		pst.setString(4, email);
		pst.setInt(5, 0);
		pst.setInt(6,department);
		pst.setInt(7, 2);
		pst.setString(8, pwd);
		pst.execute();
		pst.close();
	}
	/**
	 * 通过员工状态获取员工列表
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	
	public List<Staff> selectByStatus(String status) throws Exception {
		List<Staff> list=new ArrayList<>();
		this.openConnection();
		String sql="select * from staff01 where staffstatus=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, status);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Staff staff=new Staff();
			staff.setStaffid(rs.getInt("staffid"));
			staff.setUsername(rs.getString("username"));
			staff.setStaffname(rs.getString("staffname"));
			staff.setPhone(rs.getString("phone"));
			staff.setEmail(rs.getString("email"));
			staff.setStatus(rs.getString("staffstatus"));
			staff.setDepartmentid(rs.getInt("departmentid"));
			staff.setRole(rs.getString("roles"));
			staff.setPwd(rs.getString("pwd"));
			list.add(staff);
		}
		rs.close();
		pst.close();
		return list;
	}
	/**
	 * 修改员工状态
	 * @param status
	 * @param staffid
	 * @throws Exception
	 */
	public void changeStatus(String status,int staffid) throws Exception {
		this.openConnection();
		String sql="update staff01 set staffstatus=? where staffid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, status);
		pst.setInt(2, staffid);
		pst.execute();
		pst.close();
	}
	/**
	 * 获取数据库中有多少实体
	 * 
	 * @return
	 * @throws Exception 
	 */
	public int selectCount(String staffname,String username,String status) throws Exception {
		int totalCount=0;
		this.openConnection();
		String sql="select count(*) from staff01 where roles=2";
		if (staffname!=null && !"".equals(staffname)) {
			sql+=" and staffname like '%"+staffname+"%'";
		}
		if (username!=null && !"".equals(username)) {
			sql+=" and username like '%"+username+"%'";
		}
		if (status!=null && !"".equals(status)) {
			sql+=" and staffstatus='"+status+"'";
		}
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			totalCount=rs.getInt(1);
		}
		rs.close();
		pst.close();
		return totalCount;
	}
	/**
	 * 查询分页列表
	 * 
	 * @return
	 * @throws Exception 
	 */
	public List<Staff> pageList(int firstResult,int maxResult,String staffname,String username,String status) throws Exception {
		List<Staff> list=new ArrayList<Staff>();
		this.openConnection();
		String sql="select * from staff01 where roles=2 and staffstatus!=4";
		if (staffname!=null && !"".equals(staffname)) {
			sql+=" and staffname like '%"+staffname+"%'";
		}
		if (username!=null && !"".equals(username)) {
			sql+=" and username like '%"+username+"%'";
		}
		if (status!=null && !"".equals(status)) {
			sql+=" and staffstatus='"+status+"'";
		}
		sql+=" limit ?,?";
		PreparedStatement pst= conn.prepareStatement(sql);
		pst.setInt(1,firstResult);
		pst.setInt(2,maxResult);
		ResultSet rs=pst.executeQuery();
		while (rs.next()) {
			Staff staff=new Staff();
			staff.setStaffid(rs.getInt("staffid"));
			staff.setUsername(rs.getString("username"));
			staff.setStaffname(rs.getString("staffname"));
			staff.setPhone(rs.getString("phone"));
			staff.setEmail(rs.getString("email"));
			staff.setStatus(rs.getString("staffstatus"));
			staff.setDepartmentid(rs.getInt("departmentid"));
			staff.setRole(rs.getString("roles"));
			staff.setPwd(rs.getString("pwd"));
			list.add(staff);
		}
		rs.close();
		pst.close();
		return list;
	}
}
