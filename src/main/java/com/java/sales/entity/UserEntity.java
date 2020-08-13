package com.java.sales.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{

	
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "userComment")
	private List<CommentEntity> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "userHelp")
	private List<HelpEntity> helps = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "userid")
	private List<ReplyCommentEntity> replycommentid= new ArrayList<>();
	
	
	
	
	
	
	public List<CommentEntity> getComments() {
		return comments;
	}
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
	public List<HelpEntity> getHelps() {
		return helps;
	}
	public void setHelps(List<HelpEntity> helps) {
		this.helps = helps;
	}
	public List<ReplyCommentEntity> getReplycommentid() {
		return replycommentid;
	}
	public void setReplycommentid(List<ReplyCommentEntity> replycommentid) {
		this.replycommentid = replycommentid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}
