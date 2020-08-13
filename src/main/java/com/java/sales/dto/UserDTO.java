package com.java.sales.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String password;

	

	private List<RoleDTO> roleCodes;

	private List<HelpDTO> helps;
	
	
	

	public UserDTO(String userName, String password) {
	
		this.userName = userName;
		this.password = password;
	}

	public UserDTO() {
		
		
	}


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




	
	
	
	
}
