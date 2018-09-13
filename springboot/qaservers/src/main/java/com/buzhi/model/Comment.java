package com.buzhi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
	
	/**编号**/
	@Id
    @Column(length = 8)
	private String id;
	/**原内容编号**/
	private String contentId;
	/**作者编号**/
	private String authorId;
	/**作者**/
	private String author;
	/**评论**/
	private String comment;
	/**回复编号**/
	private String replyLink;
	/**点赞数**/
	private String agreenum;
	/**评论时间**/
	private Date createDate;
	
	/**备用字段1**/
	private String f1;
	/**备用字段2**/
	private String f2;
	/**备用字段3**/
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
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReplyLink() {
		return replyLink;
	}
	public void setReplyLink(String replyLink) {
		this.replyLink = replyLink;
	}
	public String getAgreenum() {
		return agreenum;
	}
	public void setAgreenum(String agreenum) {
		this.agreenum = agreenum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
