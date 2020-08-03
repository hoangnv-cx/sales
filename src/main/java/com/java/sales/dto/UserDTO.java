package com.java.sales.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String password;

	private String fullName;

	private List<RoleDTO> roleCodes;

	private List<HelpDTO> helps;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	public List<HelpDTO> getHelps() {
		return helps;
	}




	public void setHelps(List<HelpDTO> helps) {
		this.helps = helps;
	}




	public List<RoleDTO> getRoleCodes() {
		return roleCodes;
	}

	public void setRoleCodes(List<RoleDTO> roleCodes) {
		this.roleCodes = roleCodes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
