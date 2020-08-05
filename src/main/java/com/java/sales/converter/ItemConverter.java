package com.java.sales.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.sales.dto.CommentDTO;
import com.java.sales.dto.ItemDTO;
import com.java.sales.dto.ReplyCommentDTO;
import com.java.sales.entity.CommentEntity;
import com.java.sales.entity.ItemEntity;
import com.java.sales.entity.ReplyCommentEntity;

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
		List<CommentDTO> commentDTOs=new ArrayList<CommentDTO>();
		List<ReplyCommentDTO> replyCommentDTOs =new ArrayList<ReplyCommentDTO>();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setThumbnail(entity.getThumbnail());
		dto.setShortDescription(entity.getShortDescription());
		dto.setCreateDate(entity.getCreateDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		for(CommentEntity commentEntity:entity.getComments()) {
			CommentDTO commentDTO=new CommentDTO();
			commentDTO.setId(commentEntity.getId());
			commentDTO.setUserName(commentEntity.getUserComment().getUserName());
			commentDTO.setComments(commentEntity.getComments());
			commentDTO.setCreateDate(commentEntity.getCreateDate());
			commentDTO.setCreatedBy(commentEntity.getCreatedBy());
			commentDTO.setModifiedDate(commentEntity.getModifiedDate());
			commentDTO.setModifiedBy(commentEntity.getModifiedBy());
			
			for(ReplyCommentEntity replyCommentEntity:commentEntity.getReplyComments()) {
				ReplyCommentDTO replyCommentDTO=new ReplyCommentDTO();
				replyCommentDTO.setId(replyCommentEntity.getId());
				replyCommentDTO.setReplyComment(replyCommentEntity.getReplyComment());
				replyCommentDTO.setUserName(replyCommentEntity.getUserid().getUserName());
				replyCommentDTO.setCreateDate(replyCommentEntity.getCreateDate());
				replyCommentDTO.setCreatedBy(replyCommentEntity.getCreatedBy());
				replyCommentDTO.setModifiedBy(replyCommentEntity.getModifiedBy());
				replyCommentDTO.setModifiedDate(replyCommentEntity.getModifiedDate());
				replyCommentDTOs.add(replyCommentDTO);
			}
			commentDTO.setReplyComments(replyCommentDTOs);
			commentDTOs.add(commentDTO);
		}
		
		dto.setComments(commentDTOs);
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
