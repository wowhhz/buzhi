package com.buzhi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.buzhi.enums.ResultEnum;
import com.buzhi.model.Result;
import com.buzhi.model.User;
import com.buzhi.repository.UserRepository;
import com.buzhi.service.UserService;
import com.buzhi.utils.ResultUtil;
/**
 * 在 @PreAuthorize 中我们可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。
 * 需注意的一点是 hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。所以这里的 'ADMIN' 其实在
 * 数据库中存储的是 'ROLE_ADMIN' 。这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
 **/
@RestController
//@PreAuthorize("hasRole('USER')") //有ROLE_USER权限的用户可以访问
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	//@PreAuthorize("hasRole('ADMIN')")//有ROLE_ADMIN权限的用户可以访问
	@GetMapping(value="/users/query")
	public Result findAll(Pageable pageable){
		Page<User> page = userRepository.findAll(pageable);
		return ResultUtil.success(page);
	}
	
	@GetMapping(value="/users/get")
	public Result get(@PathParam("username") String username){
		User user = userRepository.findByUsername(username);
		return ResultUtil.success(user);
	}
	
//	@PostMapping(value="/auth/login")
//	public Result login(@AuthenticationPrincipal User loginUser, @RequestParam(name = "logout", required = false) String logout){
//		
//			if (logout != null) {
//	            return ResultUtil.success();
//	        }
//	        if (loginUser != null) {
//	            return ResultUtil.success(loginUser);
//	        }
//	        return ResultUtil.error(ResultEnum.USER_ERROR_LOGIN_FAIL);
//			
//		
//	}
	
	@PostMapping(value="/auth/login")
	public Result login(@RequestParam(name = "logout", required = false) String logout){
		
		ServletRequestAttributes servletRequestAttributes = 
				(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String username = (String)request.getAttribute("username");
		String email = (String)request.getAttribute("email");
		String password = (String)request.getAttribute("password");
		User user = userRepository.findByUsername(username);
//		User user = userRepository.findByEmail(email);
		
		//BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		//password = encoder.encode(password.trim());
		if(user==null){
			return ResultUtil.error(ResultEnum.USER_ERROR_NOUSER);
		}
		if(password.equals(user.getPassword())){
			return ResultUtil.success(user);
		}else{
			return ResultUtil.error(ResultEnum.USER_ERROR_LOGIN_FAIL);
		}
		
	}
	
	@PostMapping(value="/auth/signup")//, produces="application/json"
	public Result signup(@Valid User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(9,bindingResult.getFieldError().getDefaultMessage());
		}
		User _user = userRepository.findByEmail(user.getEmail());
		if(_user==null){
//			BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
//			user.setPassword(encoder.encode(user.getPassword().trim()));
			User newuser = userRepository.save(user);
			return ResultUtil.success(newuser);
		}else{
			return ResultUtil.error(ResultEnum.USER_ERROR_EXIST);
		}
	}
	
//	@Secured({"ROLE_ADMIN","ROLE_USER"})//此方法只允许 ROLE_ADMIN 和ROLE_USER 角色 访问
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    public Object save(@RequestBody User user) {
//        return  userRepository.save(user);
//    }
//
//
//    @Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
//    @RequestMapping(method = RequestMethod.PUT)
//    @ResponseBody
//    public String update() {
//        return "updateUser";
//    }
//
//    @Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
//    @RequestMapping(method = RequestMethod.DELETE)
//    @ResponseBody
//    public String delete() {
//        return "deleteUser";
//    }
}
