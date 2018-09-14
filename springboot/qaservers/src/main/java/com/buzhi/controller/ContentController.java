package com.buzhi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzhi.enums.ResultEnum;
import com.buzhi.model.Content;
import com.buzhi.model.Result;
import com.buzhi.repository.ContentRepository;
import com.buzhi.service.ContentService;
import com.buzhi.utils.ResultUtil;
import com.buzhi.utils.StringUtils;


@RestController
@RequestMapping(value="/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ContentRepository contentRepository;
	
	@RequestMapping(value="/hot")
	public Result hot(@PageableDefault(page=0,size=10,sort="agreenum", direction = Direction.DESC)Pageable pageable){
        Iterator<Content> all = contentRepository.findAll(pageable).iterator();
        List<Content> list = new ArrayList<Content>();
        while (all.hasNext()){
           list.add(all.next());
        }
        return ResultUtil.success(list);

	}
	
	@GetMapping(value="/query")
	public Result query(HttpServletRequest request,Pageable pageable){
		String id = request.getParameter("id");
		String ctype = request.getParameter("ctype");
		String clink = request.getParameter("clink");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//pageable.getSort().by("agreenum").descending();
		
//		List<Content> list = new ArrayList();
//		if(!StringUtils.isEmpty(id)){
//			list = contentRepository.findByClink(ctype, pageable);
//		}
//		if(!StringUtils.isEmpty(ctype)){
//			list = contentRepository.findByCtype(ctype, pageable);
//		}
//		if(!StringUtils.isEmpty(clink)){
//			list = contentRepository.findByClink(clink, pageable);
//		}
//		if(list==null || list.size()==0){
//			return ResultUtil.error(ResultEnum.CONTENT_NODATA);
//		}
		Content c = new Content();
		if(!StringUtils.isEmpty(id))c.setId(id);
		if(!StringUtils.isEmpty(ctype))c.setCtype(ctype);
		if(!StringUtils.isEmpty(clink))c.setClink(clink);
		if(!StringUtils.isEmpty(title))c.setTitle(title);
		if(!StringUtils.isEmpty(content))c.setContent(content);
		
		Page page = contentService.mulitConditionSearch(c,pageable);
		
		return ResultUtil.success(page);
	}
	
	
	@PostMapping(value="/publish")
	public Result publish(Content content){
		if(StringUtils.isEmpty(content.getId())){
			content.setId(contentService.generateUniqueCode());
			content.setCreateDate(new Date());
		}else{
			Content _content = contentRepository.findById(content.getId()).orElse(null);
			if(_content==null){
				return ResultUtil.error(ResultEnum.CONTENT_NODATA);
			}
		}
		contentRepository.save(content);
		return ResultUtil.success(content);
	}
	
}
