package com.buzhi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.buzhi.model.Content;
import com.buzhi.repository.ContentRepository;
import com.buzhi.utils.StringUtils;

@Service
public class ContentService {

	private final static Logger logger = LoggerFactory.getLogger(ContentService.class);
	
	@Autowired
	private ContentRepository contentRepository;
	
	/**
	 * @Description: 生成唯一的数字ID
	 * @return
	 */
	public String generateUniqueCode() {
		try {
			int x = 20;
			while (true) {
				// 生成随机8位随机码
				String sCode = ""+StringUtils.generateCode();
				Content content = contentRepository.findById(sCode).orElse(null);
				if (content==null) {
					return sCode;
				}else{
					x--;
					if(x==0)throw new RuntimeException("内容无法生成编号");
				}
			}
		} catch (Exception e) {
			logger.error("访问 ContentService.generateUniqueCode() 发生错误,错误信息为", e);
		}
		return "";
	}
	
	/**
	 * 多条件+分页 查询
	 * @param content
	 * @param pageable
	 * @return
	 */
	public Page<Content> mulitConditionSearch(Content content,Pageable pageable){
		
		Page<Content> page = contentRepository.findAll(new Specification<Content>() {

			@Override
			public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				//查询条件 编号 and id=?
				if(!StringUtils.isEmpty(content.getId())){
					list.add(criteriaBuilder.equal(root.get("id").as(String.class), content.getId()));
				}
				//查询条件 原链接 and clike=?
				if(!StringUtils.isEmpty(content.getClink())){
					list.add(criteriaBuilder.equal(root.get("clink").as(String.class), content.getClink()));
				}
				//查询条件 分类 and ctype=?
				if(!StringUtils.isEmpty(content.getCtype())){
					list.add(criteriaBuilder.equal(root.get("ctype").as(String.class), content.getCtype()));
				}
				//查询条件 部分标题或内容(空隔分隔) and (title like %?% or title like %?% or content like %?%)
				Map submap = new HashMap();
				List<Predicate> sublist = new ArrayList<Predicate>();
				if(!StringUtils.isEmpty(content.getTitle())){
					String[] titleStr = content.getTitle().trim().split(" ");
					for (String title : titleStr) {
						if(!StringUtils.isEmpty(title) && !submap.containsKey(title)){
							submap.put(title, title);
						}
					}
				}
				if(!StringUtils.isEmpty(content.getContent())){
					String[] contentStr = content.getContent().trim().split(" ");
					for (String content : contentStr) {
						if(!StringUtils.isEmpty(content) && !submap.containsKey(content)){
							submap.put(content, content);
						}
					}
				}
				if(submap.size()>0){
					submap.forEach((k,v)->{
						sublist.add(criteriaBuilder.like(root.get("title").as(String.class), "%"+v+"%"));
						sublist.add(criteriaBuilder.like(root.get("content").as(String.class), "%"+v+"%"));
					});
					Predicate[] subPredicates = new Predicate[sublist.size()];
					list.add(criteriaBuilder.or(sublist.toArray(subPredicates)));
				}
				
				Predicate[] predicates = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(predicates));
			}
			
		}, pageable);
		
		return page;
	}
	
}
