package com.java.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "help")
public class HelpEntity extends BaseEntity{
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "email")
	private String email;
	@Column(name = "subject")
	private String subject;
	@Column(name = "message")
	private String message;
	@Column(name = "username")
	private String username;
	@Column(name = "status")
	private int status;
	@Column(name = "title")
	private String title;
	@Column(name = "reply")
	private String reply;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserEntity userHelp;
	
	
	
	public UserEntity getUserHelp() {
		return userHelp;
	}

	public void setUserHelp(UserEntity userHelp) {
		this.userHelp = userHelp;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	
	
	

}
