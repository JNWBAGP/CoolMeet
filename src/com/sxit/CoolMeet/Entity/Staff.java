package com.sxit.CoolMeet.Entity;

public class Staff {
	//员工ID
	private int  staffid;
	//真实姓名
	private String staffname;
	//用户名
	private String username;
	//电话
	private String phone;
	//email
	private String email;
	//员工状态   0.待审批  1.审批通过  2.审批未通过  3.账户禁用  4.账户删除
	private String status;
	//员工角色   1.管理员  2.普通用户
	private String role;
	//部门标识
	private int departmentid;
	//密码
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
