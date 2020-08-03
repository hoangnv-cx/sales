package com.java.sales.converter;

import org.springframework.stereotype.Component;

import com.java.sales.dto.ItemDTO;
import com.java.sales.entity.ItemEntity;

@Component
public class ItemConverter {

	public ItemEntity dtoToEntity(ItemDTO dto) {
		ItemEntity entity=new ItemEntity();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		entity.setCreateDate(dto.getCreateDate());
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setModifiedBy(dto.getModifiedBy());
		entity.setModifiedDate(dto.getModifiedDate());
		return entity;
	}
	public ItemDTO entityToDto(ItemEntity entity) {
		ItemDTO dto=new ItemDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setThumbnail(entity.getThumbnail());
		dto.setShortDescription(entity.getShortDescription());
		dto.setCreateDate(entity.getCreateDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	public ItemEntity dtoToEntity(ItemDTO dto,ItemEntity entity) {
		
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		entity.setModifiedBy(dto.getModifiedBy());
		entity.setModifiedDate(dto.getModifiedDate());
		return entity;
	}
}
