package com.sxit.CoolMeet.Service;


import java.util.List;

import com.sxit.CoolMeet.DataBase.StaffDataBase;
import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.util.PageResult;

/*
 * 
 * */
public class StaffService {
	public Staff login(String username,String pwd) throws Exception {
		Staff staff=null;
		//调用DataBase层方法，到数据库通过用户名和方法查找用户
		StaffDataBase sdb=new StaffDataBase();
		try {
			staff=sdb.selectByIdAndPwd(username, pwd);
		} catch (Exception e) {
			throw e;
		}finally{
			sdb.closeConnection();
		}
		
		return staff;
		
	}
	/**
	 * 修改密码业务逻辑层
	 * 
	 * @param staffid
	 * @param newPwd
	 * @throws Exception
	 */
	public void changePwd(Integer staffid,String newPwd) throws Exception{
		StaffDataBase sdb=new StaffDataBase();
		try {
			sdb.changePwd(staffid, newPwd);
		} catch (Exception e) {
			throw e;
		}finally{
			sdb.closeConnection();
		}
		
	}
	
	/**
	 * 通过账户名查询员工
	 * @throws Exception 
	 */
	public Staff selectByName(String username) throws Exception{
		Staff staff=null;
		StaffDataBase sdb=new StaffDataBase();
		try {
			staff=sdb.selectByName(username);
		} catch (Exception e) {
			throw e;
		}finally{
			sdb.closeConnection();
		}
		return staff;
		
	}
	/**
	 * 注册员工，在数据库保存信息
	 * @param staffname
	 * @param username
	 * @param pwd
	 * @param phone
	 * @param email
	 * @param departmentid
	 * @throws Exception
	 */
	public void regiterStaff(String staffname,String username,String pwd,String phone,String email,int departmentid) throws Exception {
		StaffDataBase sdb=new StaffDataBase();
		try {
			sdb.saveStaff(staffname, username, pwd, phone, email, departmentid);
		} catch (Exception e) {
			throw e;
		}finally{
			sdb.closeConnection();
		}
	}
	/**
	 * 通过员工状态获取员工列表
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<Staff> selectByStats(String status) throws Exception{
		List<Staff> list=null;
		StaffDataBase sdb=new StaffDataBase();
		try {
			list=sdb.selectByStatus(status);
		} catch (Exception e) {
			throw e;
		}finally{
			sdb.closeConnection();
		}
		return list;
	}
	/**
	 * 改变员工状态
	 * 
	 * @param status
	 * @param staffid
	 * @throws Exception
	 */
	public void changeStatus(String status,int staffid) throws Exception{
		StaffDataBase sdb=new StaffDataBase();
		try {
			sdb.changeStatus(status, staffid);
		} catch (Exception e) {
			throw e;
		}finally{
			sdb.closeConnection();
		}
	}
	public void pageList(PageResult<Staff> pr,int firstResult,int maxResult,String staffname,String username,String status) throws Exception{
		StaffDataBase sdb=new StaffDataBase();
		try {
			//数据库过滤查询一共有对多少条，赋值给pr里的 totalCount;
			int totalCount=sdb.selectCount(staffname,username,status);
			pr.setTotalCount(totalCount);
			//数据库查询分页列表，赋值给pr里的list
			pr.setPageList(sdb.pageList(firstResult, maxResult,staffname,username,status));
			//数据库查询一共有多少页，赋值给pr里的 totalPage;
			pr.setTotalPage(totalCount%maxResult==0?totalCount/maxResult:totalCount/maxResult+1);
		} catch (Exception e) {
			throw e;
		}
		finally{
			sdb.closeConnection();
		}
	}
}
