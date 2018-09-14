package com.buzhi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.buzhi.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
	
	public Page<Comment> findByContentId(String contentId, Pageable pageable);
	
	public Page<Comment> findByReplyLink(String replyLink, Pageable pageable);
	
}
