package com.java.sales.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.sales.dto.CommentDTO;
import com.java.sales.dto.ReplyCommentDTO;
import com.java.sales.service.ICommentService;
import com.java.sales.service.IReplyCommentService;

@RestController
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	@Autowired
	private IReplyCommentService replyCommentService;
	
	@PostMapping(value = "/api/web/comment/firs")
	public CommentDTO createComment(@RequestBody CommentDTO dto) {
		return commentService.save(dto);
	}
	@PostMapping(value = "/api/web/comment/reply")
	public ReplyCommentDTO createReplyComment(@RequestBody ReplyCommentDTO dto) {
		return replyCommentService.save(dto);
	}
	
}
