package com.java.sales.api.output;

import java.util.ArrayList;
import java.util.List;

import com.java.sales.dto.UserDTO;

public class UserOutput {

	
	private int page;
	private int totalPgae;
	private List<UserDTO> resaults=new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPgae() {
		return totalPgae;
	}
	public void setTotalPgae(int totalPgae) {
		this.totalPgae = totalPgae;
	}
	public List<UserDTO> getResaults() {
		return resaults;
	}
	public void setResaults(List<UserDTO> resaults) {
		this.resaults = resaults;
	}
	
	
	
}
