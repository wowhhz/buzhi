package com.buzhi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
	/**用户编号**/
	@Id
	@GeneratedValue(generator = "jpa-uuid")
    @Column(length = 8)
	private String id;
	/**email**/
	@NotBlank(message = "电子邮箱地址不能为空")
	@Email(message = "电子邮箱格式错误")
	private String email;
	/**password**/
	@Length(min=3,max=20,message="密码必须在3至20个字符之间")
	@NotBlank(message = "密码不能为空")
	private String password;
	/**昵称**/
	@Length(min=3,max=30,message="昵称必须在3至30个字符之间")
	@NotBlank(message = "昵称不能为空")
	private String username;
	/**性别**/
	private String sex;
	/**生日**/
	private String birthday;
	/**地区、地址**/
	private String address;
	/**公司**/
	private String company;
	/**职业**/
	private String occupation;
	/**教育**/
	private String education;
	/**自我简介**/
	private String remark;
	
	
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
	public String getPassword() {
		return password;
	}
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
	

	
	
	
	
}
