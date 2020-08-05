package com.java.sales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.sales.Utils.SecurityUtils;
import com.java.sales.Utils.SendMail;
import com.java.sales.converter.HelpConverter;
import com.java.sales.dto.HelpDTO;
import com.java.sales.entity.HelpEntity;
import com.java.sales.entity.UserEntity;
import com.java.sales.repository.IHelpRepository;
import com.java.sales.repository.IUserRepository;
import com.java.sales.service.IHelpService;
@Service
public class HelpServiceImpl implements IHelpService{
	@Autowired
	IHelpRepository helpRepository;
	@Autowired
	HelpConverter helpConverter;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	private SendMail sendMail;
	@Override
	public HelpDTO save(HelpDTO dto) {
		HelpEntity entity=new HelpEntity();
		if(dto.getId()!=null) {				
			HelpEntity entityHelp=helpRepository.findOneById(dto.getId());
			entity=helpConverter.dtoToEntity(entityHelp, dto);
			UserEntity userEntity=userRepository.findByUserName(SecurityUtils.getName());							
			entity.setUserHelp(userEntity);
			entity.setStatus(1);
			sendMail.sendEmailTest(entityHelp.getEmail(), entityHelp.getTitle(), entityHelp.getReply());
		}else {
			entity=helpConverter.dtoToEntity(dto);
			entity.setStatus(0);		
		}
		helpRepository.save(entity);
		return helpConverter.entityToDto(entity);
	}

	@Override
	public List<HelpDTO> findAllByOrderByIdDesc() {
		List<HelpEntity> helpEntities=helpRepository.findAllByOrderByIdDesc();
		List<HelpDTO> helpDTOs=new ArrayList<HelpDTO>();
		for(HelpEntity entity:helpEntities) {
			HelpDTO dto=new HelpDTO();
			dto=helpConverter.entityToDto(entity);
			helpDTOs.add(dto);
		}
		
		return helpDTOs;
	}

	@Override
	public List<HelpDTO> findAllByOrderByIdDesc(Pageable pageable) {
		List<HelpEntity> helpEntities=helpRepository.findAllByOrderByIdDesc(pageable);
		List<HelpDTO> helpDTOs=new ArrayList<HelpDTO>();
		for(HelpEntity entity:helpEntities ) {
			HelpDTO dto=new HelpDTO();
			dto=helpConverter.entityToDto(entity);
			helpDTOs.add(dto);
		}
		return helpDTOs;
	}

	@Override
	public HelpDTO findOneById(Long id) {
		HelpEntity entity=helpRepository.findOneById(id);
		HelpDTO dto=new HelpDTO();
		dto=helpConverter.entityToDto(entity);
		return dto;
	}

	@Override
	public int count() {
		return (int) helpRepository.count();
		
	}
	

}
