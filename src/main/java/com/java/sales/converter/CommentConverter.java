package com.java.sales.converter;

import org.springframework.stereotype.Component;

import com.java.sales.dto.CommentDTO;
import com.java.sales.entity.CommentEntity;

@Component
public class CommentConverter {

	public CommentEntity dtoToEntity(CommentDTO dto) {
		CommentEntity entity=new CommentEntity();
		entity.setComments(dto.getComments());
		
		entity.setCreateDate(dto.getCreateDate());
		entity.setCreatedBy(dto.getCreatedBy());
		
		return entity;
	}
	public CommentDTO entityToDto(CommentEntity entity) {
		CommentDTO dto=new CommentDTO();
		dto.setComments(entity.getComments());
		
		dto.setCreateDate(entity.getCreateDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	public CommentEntity dtoToEntity(CommentDTO dto,CommentEntity entity) {
		entity.setId(dto.getId());
		entity.setComments(dto.getComments());
		
		
		entity.setModifiedBy(dto.getModifiedBy());
		entity.setModifiedDate(dto.getModifiedDate());
		return entity;
	}
}
