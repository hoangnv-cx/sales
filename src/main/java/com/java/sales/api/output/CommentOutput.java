package com.java.sales.api.output;

import java.util.ArrayList;
import java.util.List;

import com.java.sales.dto.CommentDTO;

public class CommentOutput {

	private int page;
	private int totalPgae;
	private List<CommentDTO> resaults=new ArrayList<>();
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
	public List<CommentDTO> getResaults() {
		return resaults;
	}
	public void setResaults(List<CommentDTO> resaults) {
		this.resaults = resaults;
	}
	
	
}
