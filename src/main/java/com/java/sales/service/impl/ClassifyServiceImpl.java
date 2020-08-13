package com.java.sales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.sales.converter.ClassifyConverter;
import com.java.sales.dto.ClassifyDTO;
import com.java.sales.entity.ClassifyEntity;
import com.java.sales.repository.IClassifyRepository;
import com.java.sales.service.IClassifyService;
@Service
public class ClassifyServiceImpl implements IClassifyService{
	@Autowired
	IClassifyRepository classRepository;
	@Autowired
	ClassifyConverter classifyConverter;
	@Override
	public List<ClassifyDTO> findAll() {
		List<ClassifyEntity> entitys=classRepository.findAll();
		List<ClassifyDTO> dtos=new ArrayList<ClassifyDTO>();
		for(ClassifyEntity entity:entitys) {
			ClassifyDTO dto=new ClassifyDTO();
			dto=classifyConverter.entityToDto(entity);		
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	public ClassifyDTO save(ClassifyDTO dto) {
		ClassifyEntity entity=new ClassifyEntity();
		if(dto.getId()!=null) {
			ClassifyEntity classifyEntity=classRepository.findOneById(dto.getId());
			entity=classifyConverter.dtoToEntity(dto, classifyEntity);
		}else {
			
			entity=classifyConverter.dtoToEntity(dto);
		}
		classRepository.save(entity);
		return classifyConverter.entityToDto(entity);
	}

}
