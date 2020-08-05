package com.java.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "replycomment")
public class ReplyCommentEntity extends BaseEntity{

	@Column(name = "replycomment")
	private String replyComment;
	
	@ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity comment;

	@ManyToOne
    @JoinColumn(name = "replycommentid")
    private UserEntity userid;
	
	
	
	
	public UserEntity getUserid() {
		return userid;
	}

	public void setUserid(UserEntity userid) {
		this.userid = userid;
	}

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
