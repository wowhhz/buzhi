package com.buzhi.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzhi.enums.ResultEnum;
import com.buzhi.exception.UserException;
import com.buzhi.model.Page;
import com.buzhi.model.Result;
import com.buzhi.model.User;
import com.buzhi.repository.UserRepository;
import com.buzhi.service.UserService;
import com.buzhi.utils.ResultUtil;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	public Result findAll(Page page){
		List<User> list = userService.findAll(page);
		return ResultUtil.success(list);
	}
	
	public Result find(@PathParam("username") String username){
		User user = userService.findByUsername(username);
		return ResultUtil.success(user);
	}
	
	@PostMapping(value="/login")
	public Result login(@PathParam("email") String email,@PathParam("password") String password){
		User user = userService.findByEmail(email);
		if(user==null){
			return ResultUtil.error(ResultEnum.USER_ERROR_NOUSER);
		}
		if(password.equals(user.getPassword())){
			return ResultUtil.success(user);
		}else{
			return ResultUtil.error(ResultEnum.USER_ERROR_LOGIN_FAIL);
		}
		
	}
	
	@PostMapping(value="/signup")//, produces="application/json"
	public Result signup(@Valid User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(9,bindingResult.getFieldError().getDefaultMessage());
		}
		User _user = userService.findByEmail(user.getEmail());
		if(_user==null){
			User newuser = userRepository.save(user);
			return ResultUtil.success(newuser);
		}else{
			return ResultUtil.error(ResultEnum.USER_ERROR_EXIST);
		}
	}
}