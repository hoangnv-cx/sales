package com.java.sales.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "detailuser")
public class DetailUserEntity extends BaseEntity{
	
	
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "sdt")
	private String sdt;
	@Column(name = "email")
	private String email;
	@Column(name = "image")
	private String image;
	@Column(name = "sex")
	private String sex;
	@Column(name = "dateofbirth")
	private Timestamp dateofbirth;
	
	
	
	
	
	
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Timestamp getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Timestamp dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	

}
