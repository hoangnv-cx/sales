package com.java.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.ReplyCommentEntity;

public interface IReplyCommentRepository extends JpaRepository<ReplyCommentEntity, Long>{

}
