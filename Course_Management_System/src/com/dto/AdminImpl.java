package com.dto;

public class AdminImpl implements Admin{

	private String usrename;
	private String password;
	
	
	public AdminImpl() {
		
		
	}
	
	public AdminImpl(String usrename, String password) {
		super();
		this.usrename = usrename;
		this.password = password;
	}

	public String getUsrename() {
		return usrename;
	}

	public void setUsrename(String usrename) {
		this.usrename = usrename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "usrename=" + usrename + ", password=" + password + "";
	}
	
	
	
}
