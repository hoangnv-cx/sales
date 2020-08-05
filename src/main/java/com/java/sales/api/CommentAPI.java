package com.java.sales.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.sales.api.output.CommentOutput;
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
	
	
	
	@GetMapping(value = "/admin/comment/list")
	public CommentOutput getListUser(@RequestParam(value = "page",required = false) Integer page,
									@RequestParam(value = "limit",required = false)Integer limit) {
		CommentOutput resault=new CommentOutput();
		if(page != null & limit != null) {
			Pageable pageable=PageRequest.of(page-1,limit);
			resault.setResaults(commentService.findAllByOrderByIdDesc(pageable));
			resault.setTotalPgae((int) Math.ceil(commentService.count())/limit);
			resault.setPage(page);
		}else {
			resault.setResaults(commentService.findAllByOrderByIdDesc());
		}		
		return resault;
	}
	@GetMapping(value = "/admin/comment/id")
	public CommentDTO getHelpById(@RequestParam("id")Long id) {
		return commentService.findOneById(id);
	}
	
	@PostMapping(value = "/api/web/comment/firs")
	public CommentDTO createComment(@RequestBody CommentDTO dto) {
		return commentService.save(dto);
	}
	@PostMapping(value = "/api/web/comment/reply")
	public ReplyCommentDTO createReplyComment(@RequestBody ReplyCommentDTO dto) {
		return replyCommentService.save(dto);
	}
	
}
