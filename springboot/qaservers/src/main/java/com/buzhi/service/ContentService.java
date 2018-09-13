package com.buzhi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
}
