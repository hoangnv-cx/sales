package com.java.sales.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.java.sales.dto.CommentDTO;

public interface ICommentService {

	CommentDTO save(CommentDTO dto);
	List<CommentDTO> findAllByOrderByIdDesc();
	List<CommentDTO> findAllByOrderByIdDesc(Pageable pageable);
	int count();
	CommentDTO findOneById(Long id);
}
