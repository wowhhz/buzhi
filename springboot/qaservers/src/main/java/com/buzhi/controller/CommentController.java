package com.buzhi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzhi.enums.ResultEnum;
import com.buzhi.model.Comment;
import com.buzhi.model.Result;
import com.buzhi.repository.CommentRepository;
import com.buzhi.service.CommentService;
import com.buzhi.utils.ResultUtil;
import com.mysql.jdbc.StringUtils;

@RestController
@RequestMapping(value="/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@RequestMapping(value="/hot")
	public Result hot(@PageableDefault(page=0,size=10,sort="agreenum,asc")Pageable pageable){
        Iterator<Comment> all = commentRepository.findAll(pageable).iterator();
        List<Comment> list = new ArrayList<Comment>();
        while (all.hasNext()){
           list.add(all.next());
        }
        return ResultUtil.success(list);

	}
	
	@GetMapping(value="/query")
	public Result query(HttpServletRequest request,Pageable pageable){
		String contentId = request.getParameter("contentId");
		String replyLink = request.getParameter("replyLink");
		List<Comment> list = new ArrayList();
		if(!StringUtils.isNullOrEmpty(contentId)){
			list = commentRepository.findByContentId(contentId, pageable);
		}
		if(!StringUtils.isNullOrEmpty(replyLink)){
			list = commentRepository.findByReplyLink(replyLink, pageable);
		}
		 
		if(list==null || list.size()==0){
			return ResultUtil.error(ResultEnum.COMMENT_NODATA);
		}
		
		return ResultUtil.success(list);
	}
	
	
	@PostMapping(value="/publish")
	public Result publish(Comment comment){
		if(StringUtils.isNullOrEmpty(comment.getId())){
			comment.setId(commentService.generateUniqueCode());
			comment.setCreateDate(new Date());
		}
		commentRepository.save(comment);
		return ResultUtil.success(comment);
	}
	
}
