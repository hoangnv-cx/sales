package com.java.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.sales.Utils.SecurityUtils;
import com.java.sales.converter.ReplyCommentConverter;
import com.java.sales.dto.ReplyCommentDTO;
import com.java.sales.entity.CommentEntity;
import com.java.sales.entity.ReplyCommentEntity;
import com.java.sales.entity.UserEntity;
import com.java.sales.repository.ICommentRepository;
import com.java.sales.repository.IReplyCommentRepository;
import com.java.sales.repository.IUserRepository;
import com.java.sales.service.IReplyCommentService;
@Service
public class ReplyCommentServiceImpl implements IReplyCommentService{
	
	@Autowired
	private ICommentRepository commentRepository;
	@Autowired
	private IReplyCommentRepository replyCommentRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ReplyCommentConverter replyCommentConverter;
	@Override
	public ReplyCommentDTO save(ReplyCommentDTO dto) {
		ReplyCommentEntity entity=new ReplyCommentEntity();
		if(dto.getCommentId()!=null) {
			CommentEntity commentEntity=commentRepository.getOne(dto.getCommentId());
			UserEntity userEntity=userRepository.findByUserName(SecurityUtils.getName());		
			entity.setReplyComment(dto.getReplyComment());
			entity.setComment(commentEntity);
			entity.setUserid(userEntity);
			replyCommentRepository.save(entity);
		}
		return replyCommentConverter.EntityToDto(entity);
	}
	
}
