package com.buzhi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.buzhi.model.Content;

public interface ContentRepository extends JpaRepository<Content, String>, JpaSpecificationExecutor<Content> {
	/**按原链接查找**/
	public Page<Content> findByClink(String clink,Pageable pageable);
	/**按类型查找**/
	public Page<Content> findByCtype(String ctype,Pageable pageable);
	
	
}
