package com.java.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.sales.dto.ReplyCommentDTO;
import com.java.sales.entity.CommentEntity;
import com.java.sales.entity.ReplyCommentEntity;
import com.java.sales.repository.ICommentRepository;
import com.java.sales.repository.IReplyCommentRepository;
import com.java.sales.service.IReplyCommentService;
@Service
public class ReplyCommentServiceImpl implements IReplyCommentService{
	
	@Autowired
	ICommentRepository commentRepository;
	@Autowired
	IReplyCommentRepository replyCommentRepository;
	@Override
	public ReplyCommentDTO save(ReplyCommentDTO dto) {
		if(dto.getCommentId()!=null) {
			CommentEntity commentEntity=commentRepository.getOne(dto.getCommentId());
			ReplyCommentEntity entity=new ReplyCommentEntity();
			entity.setReplyComment(dto.getReplyComment());
			entity.setComment(commentEntity);
			replyCommentRepository.save(entity);
		}
		return null;
	}

}
