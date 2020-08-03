package com.java.sales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.sales.converter.ItemConverter;
import com.java.sales.dto.ItemDTO;
import com.java.sales.entity.ClassifyEntity;
import com.java.sales.entity.ItemEntity;
import com.java.sales.repository.IClassifyRepository;
import com.java.sales.repository.IItemRepository;
import com.java.sales.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService{

	@Autowired
	IItemRepository itemRepository;
	@Autowired
	ItemConverter itemConverter;
	@Autowired
	IClassifyRepository classifyRepository;
	@Override
	public ItemDTO save(ItemDTO dto) {
		ItemEntity entityItem=new ItemEntity();
		
		if(dto.getId() != null) {
			ItemEntity entity=itemRepository.findOneById(dto.getId());
			entityItem=itemConverter.dtoToEntity(dto, entity);
			
		}else {
			entityItem=itemConverter.dtoToEntity(dto);
		}
		ClassifyEntity classifyEntiy=classifyRepository.findByCode(dto.getClassifyCode());
		entityItem.setClassify(classifyEntiy);
		itemRepository.save(entityItem);
		return itemConverter.entityToDto(entityItem);
	}

	@Override
	public void delete(long[] ids) {
		for(long item:ids) {
			itemRepository.deleteById(item);;
		}		
	}

	@Override
	public ItemDTO findOneById(Long id) {
		ItemEntity entity=itemRepository.findOneById(id);
		ItemDTO dto=new ItemDTO();
		dto=itemConverter.entityToDto(entity);
		
		return dto;
	}

	@Override
	public List<ItemDTO> findAllByOrderByIdDesc(Pageable pageable) {
		List<ItemEntity> entities=itemRepository.findAllByOrderByIdDesc(pageable);
		List<ItemDTO> dtos=new ArrayList<ItemDTO>();
		for(ItemEntity entity:entities) {
			ItemDTO dto=new ItemDTO();
			dto=itemConverter.entityToDto(entity);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int count() {
		
		return (int) itemRepository.count();
	}

	@Override
	public List<ItemDTO> findAllByOrderByIdDesc() {
		List<ItemEntity> entities=itemRepository.findAll();
		List<ItemDTO> dtos=new ArrayList<ItemDTO>();
		for(ItemEntity entity:entities) {
			ItemDTO dto=new ItemDTO();
			dto=itemConverter.entityToDto(entity);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ItemDTO> findAllByClassifysOrderByIdDesc(String roleCode) {
		ClassifyEntity entityClassifyEntity=classifyRepository.findByCode(roleCode);
		List<ItemEntity> entities=itemRepository.findAllByClassifyOrderByIdDesc(entityClassifyEntity);
		List<ItemDTO> dtos=new ArrayList<ItemDTO>();
		for(ItemEntity entity:entities) {
			ItemDTO dto=new ItemDTO();
			dto=itemConverter.entityToDto(entity);
			dtos.add(dto);
		}
		return dtos;
	}

}
