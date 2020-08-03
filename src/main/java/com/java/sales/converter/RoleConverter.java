package com.java.sales.converter;

import org.springframework.stereotype.Component;

import com.java.sales.dto.RoleDTO;
import com.java.sales.entity.RoleEntity;
@Component
public class RoleConverter {

	public RoleEntity dtoToEntity(RoleDTO dto) {
		RoleEntity entity=new RoleEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
	public RoleDTO entityToDto(RoleEntity entity) {
		RoleDTO dto=new RoleDTO();
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setId(entity.getId());
		return dto;
	}
	public RoleEntity dtoToEntity(RoleDTO dto,RoleEntity entity) {
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}
