package com.java.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "replycomment")
public class ReplyComment extends BaseEntity{

	@Column(name = "replycomment")
	private String replyComment;
	
	@ManyToOne
    @JoinColumn(name = "reply_comment")
    private CommentEntity comment;

	public String getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}

	public CommentEntity getComment() {
		return comment;
	}

	public void setComment(CommentEntity comment) {
		this.comment = comment;
	}
	
	
	
}
