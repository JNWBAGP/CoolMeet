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
		//����DataBase�㷽���������ݿ�ͨ���û����ͷ��������û�
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
	 * �޸�����ҵ���߼���
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
	 * ͨ���˻�����ѯԱ��
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
	 * ע��Ա���������ݿⱣ����Ϣ
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
	 * ͨ��Ա��״̬��ȡԱ���б�
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
	 * �ı�Ա��״̬
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
			//���ݿ���˲�ѯһ���жԶ���������ֵ��pr��� totalCount;
			int totalCount=sdb.selectCount(staffname,username,status);
			pr.setTotalCount(totalCount);
			//���ݿ��ѯ��ҳ�б���ֵ��pr���list
			pr.setPageList(sdb.pageList(firstResult, maxResult,staffname,username,status));
			//���ݿ��ѯһ���ж���ҳ����ֵ��pr��� totalPage;
			pr.setTotalPage(totalCount%maxResult==0?totalCount/maxResult:totalCount/maxResult+1);
		} catch (Exception e) {
			throw e;
		}
		finally{
			sdb.closeConnection();
		}
	}
}
