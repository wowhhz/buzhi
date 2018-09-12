package com.buzhi.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buzhi.service.UserService;
import com.buzhi.utils.ResultUtil;


@RestController
public class MainController {
	
	//test
	
	@RequestMapping(value="/test", method= RequestMethod.GET, produces="application/json")
	public ResponseEntity test(){
		return new ResponseEntity<>(ResultUtil.success(),HttpStatus.OK);
	}
	
	@RequestMapping("/")
    public String sayHello() {
        return "<h1>欢迎来到QA社区</h1><br />Welcome to QA Community"
        		+ "<p>以下URL为API开放示例</p>"
        		+ "<ul>"
        		+ "<li><a href=\"/hot\">热门问题  /hot</a></li>"
        		+ "<li><a href=\"/question/1\">查看问题 /question</a></li>"
        		+ "<li><a href=\"/question/1/answer/2\">查看问答 /question/{questionId}/answer/{answerId}</a></li>"
        		+ "<li><a href=\"/publish\">提交问答/publish</a></li>"
        		+ "<li><a href=\"/login\">用户登录 /login</a></li>"
        		+ "<li><a href=\"/signup\">用户注册 /signup</a></li>"
        		+ "</ul>";
    }
	
	
	
	
	
}
