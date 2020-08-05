package com.java.sales.dto;

public class ReplyCommentDTO extends BaseDTO{

	private String replyComment;
	private CommentDTO comments;
	private Long commentId;
	private String userName;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getReplyComment() {
		return replyComment;
	}
	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}
	public CommentDTO getComments() {
		return comments;
	}
	public void setComments(CommentDTO comments) {
		this.comments = comments;
	}
	
	
	
}
