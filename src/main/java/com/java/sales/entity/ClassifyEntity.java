package com.java.sales.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classify")
public class ClassifyEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	
	@Column(name = "image")
	private String image;
	
	
	@OneToMany(mappedBy = "classify")
	private List<ItemEntity> items = new ArrayList<>();
	
	
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<ItemEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
