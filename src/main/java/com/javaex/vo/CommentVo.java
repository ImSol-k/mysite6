package com.javaex.vo;

public class CommentVo {
	
	private int no;
	private int userNo;
	private int hit;
	private int groupNo;
	private int orderNo;
	private int depth;
	private String title;
	private String content;
	private String regDate;
	
	public CommentVo() {
	}
	public CommentVo(int no, int userNo, int hit, int groupNo, int orderNo, int depth, String title, String content, String regDate) {
		this.no = no;
		this.userNo = userNo;
		this.hit = hit;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", userNo=" + userNo + ", hit=" + hit + ", groupNo=" + groupNo + ", orderNo="
				+ orderNo + ", depth=" + depth + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ "]";
	}
	
}
