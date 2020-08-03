package com.java.sales.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.sales.api.output.HelpOutput;
import com.java.sales.dto.HelpDTO;
import com.java.sales.service.IHelpService;

@RestController
public class HelpAPI {
	
	
	
	
	@Autowired
	IHelpService helpService;
	
	@GetMapping(value = "/admin/help/list")
	public HelpOutput getListHelp(@RequestParam(value = "page",required = false)Integer page,
									@RequestParam(value = "limit",required = false)Integer limit) {
		
		HelpOutput resllts=new HelpOutput();
		if(page != null & limit != null) {
			Pageable pageable=PageRequest.of(page-1,limit);
			resllts.setResaults(helpService.findAllByOrderByIdDesc(pageable));
			resllts.setTotalPgae((int) Math.ceil(helpService.count())/limit);
			resllts.setPage(page);
		}else {
			resllts.setResaults(helpService.findAllByOrderByIdDesc());
		}
		return resllts;
	}
	@GetMapping(value = "/admin/help/id")
	public HelpDTO getHelpById(@RequestParam("id")Long id) {
		return helpService.findOneById(id);
	}
	@PostMapping(value = "/api/web/help")
	public HelpDTO addHelp(@RequestBody HelpDTO dto) {
		return helpService.save(dto);
	}
	@PutMapping(value = "/api/admin/help")
	public HelpDTO updateHelp(@RequestBody HelpDTO dto) {
		return helpService.save(dto);
	}
}
