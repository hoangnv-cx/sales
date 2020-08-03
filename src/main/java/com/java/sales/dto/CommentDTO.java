package com.java.sales.dto;

public class CommentDTO extends BaseDTO{
	
	
	private String comments;
	private Long useridcomment;
	private Long itemComment;
	private String userComment;
	
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
