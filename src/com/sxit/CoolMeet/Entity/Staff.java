package com.sxit.CoolMeet.Entity;

public class Staff {
	//Ա��ID
	private int  staffid;
	//��ʵ����
	private String staffname;
	//�û���
	private String username;
	//�绰
	private String phone;
	//email
	private String email;
	//Ա��״̬   0.������  1.����ͨ��  2.����δͨ��  3.�˻�����  4.�˻�ɾ��
	private String status;
	//Ա����ɫ   1.����Ա  2.��ͨ�û�
	private String role;
	//���ű�ʶ
	private int departmentid;
	//����
	private String pwd;
	
	
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int i) {
		this.departmentid = i;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
