package com.javaex.vo;

public class BoardVo {
	private int no;
	private int hit;
	private int userNo;
	private String title;
	private String content;
	private String regDate;
	private String name;
	private String find;
	
	public BoardVo() {
	}
	public BoardVo(int no, int hit, int userNo, String title, String content, String regDate, String name) {
		this.no = no;
		this.hit = hit;
		this.userNo = userNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.name = name;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", hit=" + hit + ", userNo=" + userNo + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", name=" + name + "]";
	}

	
	
}
