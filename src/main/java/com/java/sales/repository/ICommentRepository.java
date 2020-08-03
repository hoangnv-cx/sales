package com.java.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.CommentEntity;

public interface ICommentRepository extends JpaRepository<CommentEntity, Long>{

}
