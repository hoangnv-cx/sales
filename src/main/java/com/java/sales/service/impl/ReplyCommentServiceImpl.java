package com.java.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.sales.Utils.SecurityUtils;
import com.java.sales.dto.CommentDTO;
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
	@Override
	public ReplyCommentDTO save(ReplyCommentDTO dto) {
		if(dto.getCommentId()!=null) {
			CommentEntity commentEntity=commentRepository.getOne(dto.getCommentId());
			UserEntity userEntity=userRepository.findByUserName(SecurityUtils.getName());
			ReplyCommentEntity entity=new ReplyCommentEntity();
			entity.setReplyComment(dto.getReplyComment());
			entity.setComment(commentEntity);
			entity.setUserid(userEntity);
			
			replyCommentRepository.save(entity);
		}
		return null;
	}
	
}
