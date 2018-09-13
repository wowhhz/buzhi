package com.buzhi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.buzhi.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
	
	public List<Comment> findByContentId(String contentId, Pageable pageable);
	
	public List<Comment> findByReplyLink(String replyLink, Pageable pageable);
	
}
