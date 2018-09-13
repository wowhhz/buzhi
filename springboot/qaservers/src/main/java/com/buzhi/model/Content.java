package com.buzhi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Content {
	/**编号**/
	@Id
    @Column(length = 8)
	private String id;
	/**标题**/
	private String title;
	/**内容**/
	private String content;
	/**话题**/
	private String flags;
	/**类型 q或a**/
	private String ctype;
	/**是否匿名**/
	private String anonymous;
	/**用户编号**/
	private String authorID;
	/**用户名称**/
	private String author;
	/**原链接**/
	private String clink;
	/**是否允许转载**/
	private String isReprint;
	/**是否允许评论**/
	private String isComment;
	/**点赞数**/
	private int agreenum;
	
	/**发布时间**/
	private Date createDate;
	/**更新时间**/
	private Date updateDate;
	/**备用字段1**/
	private String f1;
	/**备用字段2**/
	private String f2;
	/**备注字段3**/
	private String f3;
	/**备用字段4**/
	private String f4;
	/**备用字段5**/
	private String f5;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getClink() {
		return clink;
	}
	public void setClink(String clink) {
		this.clink = clink;
	}
	public String getIsReprint() {
		return isReprint;
	}
	public void setIsReprint(String isReprint) {
		this.isReprint = isReprint;
	}
	public String getIsComment() {
		return isComment;
	}
	public void setIsComment(String isComment) {
		this.isComment = isComment;
	}
	public int getAgreenum() {
		return agreenum;
	}
	public void setAgreenum(int agreenum) {
		this.agreenum = agreenum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getF1() {
		return f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}
	public String getF2() {
		return f2;
	}
	public void setF2(String f2) {
		this.f2 = f2;
	}
	public String getF3() {
		return f3;
	}
	public void setF3(String f3) {
		this.f3 = f3;
	}
	public String getF4() {
		return f4;
	}
	public void setF4(String f4) {
		this.f4 = f4;
	}
	public String getF5() {
		return f5;
	}
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	
	

}
