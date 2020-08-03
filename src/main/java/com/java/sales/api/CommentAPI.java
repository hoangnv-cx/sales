package com.java.sales.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.sales.dto.CommentDTO;
import com.java.sales.service.ICommentService;

@RestController
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	
	
	@PostMapping(value = "/api/web/comment")
	public CommentDTO createComment(@RequestBody CommentDTO dto) {
		return commentService.save(dto);
	}
	
}
