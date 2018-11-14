package com.sxit.CoolMeet.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxit.CoolMeet.Entity.Department;

/*
 * 查询所有部门
 * 
 * 
 * */
public class DepartmentDataBase extends BaseDao {
	public List<Department> selectAll() throws Exception {
		List<Department> list=new ArrayList<Department>();
		this.openConnection();
		String sql="select * from department";
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Department department=new Department();
			department.setDepartmentid(rs.getInt("departmentid"));
			department.setDepartmentname(rs.getString("departmentname"));
			list.add(department);
		}
		rs.close();
		pst.close();		
		return list;
	}
	/**
	 * 保存添加部门信息
	 * 
	 * @param departmentname
	 * @throws Exception
	 */
	
	public void  saveDepartment(String departmentname) throws Exception {
		this.openConnection();
		String sql="insert into department(departmentname) values(?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, departmentname);
		pst.execute();
		pst.close();
	}
	/**
	 * 删除部门时改变员工状态为4
	 * @throws Exception
	 */
	public void deleteStaffByDepid(int departmentid) throws Exception{
		this.openConnection();
		String sql="update staff01 set staffstatus=4 where departmentid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1,departmentid);
		pst.execute();
		pst.close();
	}
	/**
	 * 通过部门ID删除部门
	 * 
	 * @param departmentid
	 * @throws Exception 
	 */
	public void deleteDepartment(int departmentid) throws Exception{
		this.openConnection();
		String sql="delete from department where departmentid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1,departmentid);
		pst.execute();
		pst.close();
	} 
	/**
	 * 通过部门ID修改部门名称
	 * 
	 * @param departmentid
	 * @param departmentname
	 * @throws Exception 
	 */
	public void updateDepartment(int departmentid,String departmentname) throws Exception{
		this.openConnection();
		String sql="update department set departmentname=? where departmentid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, departmentname);
		pst.setInt(2, departmentid);
		pst.execute();
		pst.close();
	}
}
