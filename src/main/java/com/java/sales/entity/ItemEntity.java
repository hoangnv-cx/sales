package com.java.sales.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class ItemEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Long price;
	@Column(name = "thumbnail")
	private String thumbnail;
	@Column(name = "shortdescription")
	private String shortDescription;
	
	@ManyToOne
    @JoinColumn(name = "classify_id")
    private ClassifyEntity classify;
	
	@OneToMany(mappedBy = "itemComment")
	private List<CommentEntity> comments = new ArrayList<>();
	
	
	
	public List<CommentEntity> getComments() {
		return comments;
	}
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
	public ClassifyEntity getClassify() {
		return classify;
	}
	public void setClassify(ClassifyEntity classify) {
		this.classify = classify;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
}
