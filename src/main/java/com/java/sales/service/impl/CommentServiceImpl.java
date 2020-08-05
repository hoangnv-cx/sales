package com.java.sales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.sales.Utils.SecurityUtils;
import com.java.sales.converter.CommentConverter;
import com.java.sales.dto.CommentDTO;
import com.java.sales.entity.CommentEntity;
import com.java.sales.repository.ICommentRepository;
import com.java.sales.repository.IItemRepository;
import com.java.sales.repository.IUserRepository;
import com.java.sales.service.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired
	private IItemRepository itemRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ICommentRepository commentRepostory;
	@Autowired
	private CommentConverter commentConverter;
	@Override
	public CommentDTO save(CommentDTO dto) {
		CommentEntity entity=new CommentEntity();
		if(dto.getId()!=null) {
			CommentEntity commentEntity=commentRepostory.getOne(dto.getId());
			entity=commentConverter.dtoToEntity(dto, commentEntity);
			entity.setUserComment(userRepository.findByUserName(SecurityUtils.getName()));
			entity.setItemComment(itemRepository.findOneById(dto.getItemComment()));
			
		}else {
			entity=commentConverter.dtoToEntity(dto);
			entity.setUserComment(userRepository.findByUserName(SecurityUtils.getName()));
			entity.setItemComment(itemRepository.findOneById(dto.getItemComment()));
		}
		commentRepostory.save(entity);
		return commentConverter.entityToDto(entity);
	}
	@Override
	public List<CommentDTO> findAllByOrderByIdDesc() {
		List<CommentEntity> commentEntities=commentRepostory.findAllByOrderByIdDesc();
		List<CommentDTO> commentDTOs=new ArrayList<CommentDTO>();
		for(CommentEntity entity:commentEntities) {
			CommentDTO dto=new CommentDTO();
			dto=commentConverter.entityToDto(entity);
			commentDTOs.add(dto);
		}
		
		return commentDTOs;
	}
	@Override
	public List<CommentDTO> findAllByOrderByIdDesc(Pageable pageable) {
		List<CommentEntity> commentEntities=commentRepostory.findAllByOrderByIdDesc(pageable);
		List<CommentDTO> commentDTOs=new ArrayList<CommentDTO>();
		for(CommentEntity entity:commentEntities) {
			CommentDTO dto=new CommentDTO();
			dto=commentConverter.entityToDto(entity);
			commentDTOs.add(dto);
		}
		
		return commentDTOs;
	}
	@Override
	public int count() {
		return (int) itemRepository.count();
	}
	@Override
	public CommentDTO findOneById(Long id) {
		CommentEntity entity=commentRepostory.findOneById(id);
		CommentDTO dto=new CommentDTO();
		dto=commentConverter.entityToDto(entity);
		return dto;
	}

}
