package com.java.sales.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.sales.Utils.DateUtil;
import com.java.sales.Utils.SecurityUtils;
import com.java.sales.dto.HelpDTO;
import com.java.sales.entity.HelpEntity;
@Component
public class HelpConverter {
	
	
	@Autowired
	private DateUtil dateUtil;
	public HelpEntity dtoToEntity(HelpDTO dto) {
		HelpEntity entity=new HelpEntity();
		entity.setUsername(SecurityUtils.getName());
		entity.setFirstName(dto.getFirstName());
		entity.setMessage(dto.getMessage());		
		entity.setSubject(dto.getSubject());
		entity.setEmail(dto.getEmail());
		return entity;
	}
	public HelpDTO entityToDto(HelpEntity entity) {
		HelpDTO model=new HelpDTO();
		model.setId(entity.getId());
		model.setUserName(entity.getUsername());
		model.setFirstName(entity.getFirstName());
		model.setMessage(entity.getMessage()); 
		model.setSubject(entity.getSubject());
		model.setEmail(entity.getEmail());
		if(entity.getStatus()==0) {
			model.setStatusTitle("Chưa xử lý");
		}else {
			model.setStatusTitle("Đã xử lý");
		}
		model.setCreateDate(dateUtil.getDate(entity.getCreateDate()));
		model.setModifiedDate(dateUtil.getDate(entity.getModifiedDate()));
		model.setCreatedBy(entity.getCreatedBy());
		model.setModifiedBy(entity.getModifiedBy());
		model.setTitle(entity.getTitle());
		model.setReply(entity.getReply());
		return model;
	}
	public HelpEntity dtoToEntity(HelpEntity entity,HelpDTO dto) {
		
		entity.setTitle(dto.getTitle());
		entity.setReply(dto.getReply());	
		return entity;
	}


}
