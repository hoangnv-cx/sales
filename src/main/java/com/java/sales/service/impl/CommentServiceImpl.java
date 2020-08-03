package com.java.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

}
