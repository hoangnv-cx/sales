package com.java.sales.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.sales.api.output.ClassifyOutput;
import com.java.sales.dto.ClassifyDTO;
import com.java.sales.service.IClassifyService;

@RestController
public class ClassifyAPI {
	@Autowired
	private IClassifyService classifyService;
	
	
	@GetMapping(value = "/web/classify/list")
	public ClassifyOutput getListClassify() {
		ClassifyOutput resaults=new ClassifyOutput();
		resaults.setResaults(classifyService.findAll());
		return resaults;
	}
	@PostMapping(value = "/api/admin/classify")
	public ClassifyDTO addClassify(@RequestBody ClassifyDTO dto) {
		
		return classifyService.save(dto);
	}
	@PutMapping(value = "/api/admin/classify")
	public ClassifyDTO updateClassify(@RequestBody ClassifyDTO dto) {
		
		return classifyService.save(dto);
	}
}
