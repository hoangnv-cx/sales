package com.java.sales.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.java.sales.Utils.DateUtil;
import com.java.sales.dto.UserDTO;
import com.java.sales.entity.UserEntity;
@Component
public class UserConverter {
	@Autowired 
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DateUtil dateUtil;
	public UserEntity dtoToEntity(UserDTO dto) {
		UserEntity entity=new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setFullName(dto.getFullName());
		return entity;
	}
	public UserDTO entityToDto(UserEntity entity) {
		UserDTO dto=new UserDTO();
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setFullName(entity.getFullName());
		dto.setCreateDate(dateUtil.getDate(entity.getCreateDate()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(dateUtil.getDate(entity.getModifiedDate()));
		return dto;
	}
	public UserEntity dtoToEntity(UserDTO dto,UserEntity entity) {		
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setFullName(dto.getFullName());
		return entity;
	}
}
