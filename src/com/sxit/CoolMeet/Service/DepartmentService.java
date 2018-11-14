package com.sxit.CoolMeet.Service;

import java.util.List;

import com.sxit.CoolMeet.DataBase.DepartmentDataBase;
import com.sxit.CoolMeet.Entity.Department;


/*
 * ���ڲ��ŵ�ҵ���߼�
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
	 * ���沿����Ϣ
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
	 * ͨ��ɾ��������ɾ��Ա��
	 * @throws Exception 
	 * 
	 */
	public  void deleteStaffByDepid(int departmentid) throws Exception{
		DepartmentDataBase ddb=new DepartmentDataBase();
		try {
			//��������
			ddb.beginTransaction();
			//ɾ���ò�����Ա��
			ddb.deleteStaffByDepid(departmentid);
			//ɾ���ò���
			ddb.deleteDepartment(departmentid);
			//�ύ����
			ddb.commit();
		} catch (Exception e) {
			ddb.rollback();
			throw e;
		}finally{
			ddb.closeConnection();
		}
	}
	/**
	 * ͨ������ID�޸Ĳ�������
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
