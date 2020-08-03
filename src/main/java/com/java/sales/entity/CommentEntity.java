package com.java.sales.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity{

	@Column(name = "comments")
	private String comments;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private UserEntity userComment;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemid")
	private ItemEntity itemComment;

	
	@OneToMany(mappedBy = "comment")
	private List<ReplyComment> replyComments = new ArrayList<>();
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

	public UserEntity getUserComment() {
		return userComment;
	}

	public void setUserComment(UserEntity userComment) {
		this.userComment = userComment;
	}

	public ItemEntity getItemComment() {
		return itemComment;
	}

	public void setItemComment(ItemEntity itemComment) {
		this.itemComment = itemComment;
	}

}
