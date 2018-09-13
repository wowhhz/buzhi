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
        		+ "<li><h5>用户模块<h5>"
        		+ "<ul>"
        		+ "<li>用户登录 <a href=\"/login\">/login</a></li>"
        		+ "<li>用户注册 <a href=\"/signup\">/signup</a></li>"
        		+ "</ul>"
        		+ "</li>"
        		+ "<li><h5>问答模块<h5>"
        		+ "<ul>"
        		+ "<li>热门问题 <a href=\"/content/hot\"> /content/hot</a></li>"
        		+ "<li>查看问答 <a href=\"/content/query?id=1&ctype=1&clink=1\">/content/query</a><br/> 参数：id：编号、ctype：类型(q-问题,a-回答)、clink：问题编号，返回报文按赞同数排序</li>"
        		+ "<li>提交问答 <a href=\"/content/publish\">/content/publish</a></li>"
        		+ "</ul>"
        		+ "</li>"
        		+ "<li><h5>评论模块<h5>"
        		+ "<ul>"
        		+ "<li>热门评论 <a href=\"/comment/hot\">/comment/hot</a></li>"
        		+ "<li>查看问题 <a href=\"/comment/query?contentId=1&replyLink=1\">/comment/query</a><br/> 参数：id：编号、contentId：回答编号、replyLink：回复消息编号，返回报文按赞同数排序</li>"
        		+ "<li>提交问答<a href=\"/comment/publish\">/comment/publish</a></li>"
        		+ "</ul>"
        		+ "</li>"
        		+ "</ul>";
    }
	
	
	
	
	
}
