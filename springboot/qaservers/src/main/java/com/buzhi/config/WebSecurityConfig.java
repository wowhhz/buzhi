package com.buzhi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.buzhi.service.UserService;

/**
 * Created by yangyibo on 17/1/18.
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)// 控制权限注解
//@Profile(value = {"development", "production"})
public class WebSecurityConfig {// extends WebSecurityConfigurerAdapter
//	 // Spring会自动寻找实现接口的类注入,会找到我们的 UserDetailsServiceImpl类
//	@Autowired
//    private  UserService userService;
//
//   @Autowired
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//   }
//   
//   /**
//    * spring Security 访问规则，注释后即为不启用
//    */
//   @Override
//   protected void configure(HttpSecurity httpSecurity) throws Exception {
//       // 取消csrf
//       httpSecurity.csrf().disable()
//		    // 基于token，所以不需要session
//		       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		       .and()
//               .authorizeRequests()
//               .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//               // 对于获取token的rest api要允许匿名访问
//               .antMatchers("/auth/**",
//            		   "/content/hot",
//            		   "/content/query/**",
//            		   "/comment/hot",
//            		   "/comment/query/**"
//            		   ).permitAll()
//               // 允许对于网站静态资源的无授权访问
//               .antMatchers(
//                       HttpMethod.GET,
//                       "/",
//                       "/*.html",
//                       "/favicon.ico",
//                       "/**/*.html",
//                       "/**/*.css",
//                       "/**/*.js",
//                       "/webjars/**",
//                       "/swagger-resources/**",
//                       "/*/api-docs"
//               ).permitAll()
//               .antMatchers(HttpMethod.POST)
//               .authenticated()
//               .antMatchers(HttpMethod.PUT)
//               .authenticated()
//               .antMatchers(HttpMethod.DELETE)
//               .authenticated()
//               .antMatchers("/shutdown").hasRole("ADMIN") //权限为数据库中已有权限，拥有该权限的用户才能关闭服务。
//            // 除上面外的所有请求全部需要鉴权认证
//               .anyRequest().authenticated()
//               .and()
//               .httpBasic();
//            // 禁用缓存
//               httpSecurity.headers().cacheControl();
//   }
//   
//   @Autowired
//   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//       auth
//           .inMemoryAuthentication()
//               .withUser("user").password("password").roles("USER")
//               .and()
//               .withUser("admin").password("admin").roles("ADMIN");;
//   }
}
