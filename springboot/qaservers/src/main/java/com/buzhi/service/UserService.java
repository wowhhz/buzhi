package com.buzhi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.buzhi.model.SysRole;
import com.buzhi.model.User;
import com.buzhi.repository.UserRepository;

@Service
public class UserService{// implements UserDetailsService
	
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
//	/**
//     * 提供一种从用户名可以查到用户并返回的方法
//     * @param account 帐号
//     * @return UserDetails
//     * @throws UsernameNotFoundException
//     */
//	@Override
//    public UserDetails loadUserByUsername(String username) {
//
//        User user = userRepository.findByUsername(username);
//        
//        if(user == null){
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//        for(SysRole role:user.getRoles()){
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            logger.info("loadUserByUsername: " + user);
//        }
//        user.setGrantedAuthorities(authorities); //用于登录时 @AuthenticationPrincipal 标签取值
//        return user;
//    }
}
