package com.java.sales.converter;

import org.springframework.stereotype.Component;

import com.java.sales.dto.ClassifyDTO;
import com.java.sales.entity.ClassifyEntity;
@Component
public class ClassifyConverter {
	
	public ClassifyEntity dtoToEntity(ClassifyDTO dto) {
		ClassifyEntity entity=new ClassifyEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setImage(dto.getImage());
		return entity;
	}
	public ClassifyDTO entityToDto(ClassifyEntity entity) {
		ClassifyDTO dto=new ClassifyDTO();
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setImage(entity.getImage());
		dto.setId(entity.getId());
		return dto;
	}
	public ClassifyEntity dtoToEntity(ClassifyDTO dto,ClassifyEntity entity) {
		entity.setImage(dto.getImage());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}
