package com.java.sales.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.sales.dto.CommentDTO;
import com.java.sales.dto.ReplyCommentDTO;
import com.java.sales.entity.CommentEntity;
import com.java.sales.entity.ReplyCommentEntity;

@Component
public class CommentConverter {

	
	
	public CommentEntity dtoToEntity(CommentDTO dto) {
		CommentEntity entity=new CommentEntity();
		entity.setComments(dto.getComments());
		
		
		
		return entity;
	}
	public CommentDTO entityToDto(CommentEntity entity) {
		CommentDTO dto=new CommentDTO();
		
		List<ReplyCommentDTO> replyCommentDTOs=new ArrayList<ReplyCommentDTO>();
		dto.setComments(entity.getComments());
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserComment().getUserName());
		for(ReplyCommentEntity commentEntity:entity.getReplyComments()) {
			ReplyCommentDTO commentDTO=new ReplyCommentDTO();
			commentDTO.setId(commentEntity.getId());
			commentDTO.setReplyComment(commentEntity.getReplyComment());
			commentDTO.setUserName(commentEntity.getUserid().getUserName());
			commentDTO.setCreateDate(commentEntity.getCreateDate());
			commentDTO.setCreatedBy(commentEntity.getCreatedBy());
			commentDTO.setModifiedBy(commentEntity.getModifiedBy());
			commentDTO.setModifiedDate(commentEntity.getModifiedDate());
			
			replyCommentDTOs.add(commentDTO);
		}
		dto.setReplyComments(replyCommentDTOs);
		dto.setCreateDate(entity.getCreateDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	public CommentEntity dtoToEntity(CommentDTO dto,CommentEntity entity) {
		entity.setId(dto.getId());
		entity.setComments(dto.getComments());

		return entity;
	}
}
