package com.buzhi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.buzhi.model.Content;

public interface ContentRepository extends JpaRepository<Content, String> {
	/**按原链接查找**/
	public List<Content> findByClink(String clink,Pageable pageable);
	/**按类型查找**/
	public List<Content> findByCtype(String ctype,Pageable pageable);
	
	
}
