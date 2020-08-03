package com.java.sales.api.output;

import java.util.ArrayList;
import java.util.List;

import com.java.sales.dto.ClassifyDTO;

public class ClassifyOutput {
	
	private List<ClassifyDTO> resaults=new ArrayList<>();

	public List<ClassifyDTO> getResaults() {
		return resaults;
	}

	public void setResaults(List<ClassifyDTO> resaults) {
		this.resaults = resaults;
	}

	
	
}
