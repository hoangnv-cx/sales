package com.java.sales.api.output;

import java.util.ArrayList;
import java.util.List;

import com.java.sales.dto.ItemDTO;

public class ItemOutput {

	private int page;
	private int totalPgae;
	private List<ItemDTO> resaults=new ArrayList<ItemDTO>();
	
	
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
	public List<ItemDTO> getResaults() {
		return resaults;
	}
	public void setResaults(List<ItemDTO> resaults) {
		this.resaults = resaults;
	}
	
	
}
