package com.java.sales.dto;

import java.util.List;

public class CommentDTO extends BaseDTO{
	
	
	private String comments;
	private Long useridcomment;
	private Long itemComment;
	private String userComment;
	private List<ReplyCommentDTO> replyComments;
	
	
	
	public List<ReplyCommentDTO> getReplyComments() {
		return replyComments;
	}
	public void setReplyComments(List<ReplyCommentDTO> replyComments) {
		this.replyComments = replyComments;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Long getUseridcomment() {
		return useridcomment;
	}
	public void setUseridcomment(Long useridcomment) {
		this.useridcomment = useridcomment;
	}
	public Long getItemComment() {
		return itemComment;
	}
	public void setItemComment(Long itemComment) {
		this.itemComment = itemComment;
	}
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	
	
	

}
