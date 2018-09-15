package com.buzhi.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User{// implements UserDetails

	private static final long serialVersionUID = 1L;
	// @AuthenticationPrincipal 标签取值
	
	/** 用户编号 **/
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 8)
	private String id;
	/** email **/
	@NotBlank(message = "电子邮箱地址不能为空")
	@Email(message = "电子邮箱格式错误")
	private String email;
	/** password **/
	@Length(min = 3, max = 20, message = "密码必须在3至20个字符之间")
	@NotBlank(message = "密码不能为空")
	@JsonIgnore
	private String password;
	/** 昵称 **/
	@Length(min = 3, max = 30, message = "昵称必须在3至30个字符之间")
	@NotBlank(message = "昵称不能为空")
	private String username;
	/** 性别 **/
	private String sex;
	/** 生日 **/
	private String birthday;
	/** 地区、地址 **/
	private String address;
	/** 公司 **/
	private String company;
	/** 职业 **/
	private String occupation;
	/** 教育 **/
	private String education;
	/** 自我简介 **/
	private String remark;
	
	public User() {
		super();
	}
	
	@JsonIgnore
	@Transient
	private List<SysRole> roles;
	
//	@Transient
//	private Collection<? extends GrantedAuthority> authorities;
	
//	public User(String id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//    }


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	// 账户是否未过期
//	@JsonIgnore
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//	// 账户是否未锁定
//	@JsonIgnore
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//	// 密码是否未过期
//	@JsonIgnore
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//	// 账户是否激活
//	@JsonIgnore
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}


	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//	
//	public void setGrantedAuthorities(Collection<? extends GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}

}
