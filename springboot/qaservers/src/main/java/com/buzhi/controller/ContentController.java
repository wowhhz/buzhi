package com.buzhi.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzhi.repository.UserRepository;
import com.buzhi.service.UserService;
import com.buzhi.utils.ResultUtil;

@RestController
public class ContentController {

//	@Autowired
//	private ContentService contentService;
//	
//	@Autowired
//	private ContentRepository contentRepository;
	
	@RequestMapping(value="/hot", produces="application/json")
	public ResponseEntity hot(){
		return new ResponseEntity<>(ResultUtil.success(), HttpStatus.OK);
	}
	
	@GetMapping(value="/question/{qid}", produces="application/json")
	public ResponseEntity question(@PathVariable("qid") String qid){
		return new ResponseEntity<>(ResultUtil.success(), HttpStatus.OK);
	}
	
	@GetMapping(value="/question/{qid}/answer/{aid}", produces="application/json")
	public ResponseEntity question(@PathVariable("qid") String qid,
			@PathVariable("aid") String aid){
		return new ResponseEntity<>(ResultUtil.success(), HttpStatus.OK);
	}
	
	
	@PostMapping(value="/publish", produces="application/json")
	public ResponseEntity publish(@PathParam("title") String username,@PathParam("content") String password){
		return new ResponseEntity<>(ResultUtil.success(), HttpStatus.OK);
	}
}
