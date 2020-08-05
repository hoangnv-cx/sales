package com.java.sales.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.CommentEntity;

public interface ICommentRepository extends JpaRepository<CommentEntity, Long>{
	List<CommentEntity> findAllByOrderByIdDesc();
	List<CommentEntity> findAllByOrderByIdDesc(Pageable pageable);
	CommentEntity findOneById(Long id);
}
