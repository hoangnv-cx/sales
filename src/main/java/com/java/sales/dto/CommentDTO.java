package com.java.sales.dto;

import java.util.List;

public class CommentDTO extends BaseDTO{
	
	
	private String comments;
	
	private Long itemComment;
	private String userComment;
	private List<ReplyCommentDTO> replyComments;
	private String userName;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
