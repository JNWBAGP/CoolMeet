package com.sxit.CoolMeet.Service;

import java.util.List;

import com.sxit.CoolMeet.DataBase.DepartmentDataBase;
import com.sxit.CoolMeet.Entity.Department;


/*
 * 关于部门的业务逻辑
 * */
public class DepartmentService {
	public List<Department> selectAlldep() throws Exception {
		DepartmentDataBase ddb=new DepartmentDataBase();
		List<Department> list;
		try {
			list = ddb.selectAll();
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
	/**
	 * 保存部门信息
	 * 
	 * @param departmentname
	 * @throws Exception
	 */
	public void saveDepartment(String departmentname) throws Exception{
		DepartmentDataBase ddb=new DepartmentDataBase();
		try {
			ddb.saveDepartment(departmentname);
		} catch (Exception e) {
			throw e;
		}finally{
			ddb.closeConnection();
		}
	}
	/**
	 * 通过删除部门来删除员工
	 * @throws Exception 
	 * 
	 */
	public  void deleteStaffByDepid(int departmentid) throws Exception{
		DepartmentDataBase ddb=new DepartmentDataBase();
		try {
			//开启事物
			ddb.beginTransaction();
			//删除该部门下员工
			ddb.deleteStaffByDepid(departmentid);
			//删除该部门
			ddb.deleteDepartment(departmentid);
			//提交事物
			ddb.commit();
		} catch (Exception e) {
			ddb.rollback();
			throw e;
		}finally{
			ddb.closeConnection();
		}
	}
	/**
	 * 通过部门ID修改部门名称
	 * 
	 * @param departmentid
	 * @param departmentname
	 * @throws Exception 
	 */
	public void updateDepartment(int departmentid,String departmentname) throws Exception {
		DepartmentDataBase ddb=new DepartmentDataBase();
		try {
			ddb.updateDepartment(departmentid, departmentname);
		} catch (Exception e) {
			throw e;
		}finally{
			ddb.closeConnection();
		}
	
	}
	
}
