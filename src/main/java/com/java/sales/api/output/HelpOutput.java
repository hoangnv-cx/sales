package com.java.sales.api.output;

import java.util.ArrayList;
import java.util.List;

import com.java.sales.dto.HelpDTO;

public class HelpOutput {

	private int page;
	private int totalPgae;
	private List<HelpDTO> resaults=new ArrayList<>();
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
	public List<HelpDTO> getResaults() {
		return resaults;
	}
	public void setResaults(List<HelpDTO> resaults) {
		this.resaults = resaults;
	}
	
	
}
