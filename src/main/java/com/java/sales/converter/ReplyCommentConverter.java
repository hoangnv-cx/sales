package com.java.sales.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.sales.Utils.DateUtil;
import com.java.sales.dto.ReplyCommentDTO;
import com.java.sales.entity.ReplyCommentEntity;
@Component
public class ReplyCommentConverter {

	@Autowired
	private DateUtil dateUtil;
	
	public ReplyCommentDTO EntityToDto(ReplyCommentEntity entity) {
		ReplyCommentDTO dto=new ReplyCommentDTO();
		dto.setId(entity.getId());
		dto.setReplyComment(entity.getReplyComment());
		dto.setCreateDate(dateUtil.getDate(entity.getCreateDate()));
		dto.setModifiedDate(dateUtil.getDate(entity.getModifiedDate()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setUserName(entity.getUserid().getUserName());
		dto.setCommentId(entity.getComment().getId());
		return dto;
	}
}
