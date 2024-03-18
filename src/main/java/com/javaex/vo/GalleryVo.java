package com.javaex.vo;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVo {

		private int no;
		private int userNo;
		private MultipartFile file;
		private String orgName;
		private String saveName;
		private String filePath;
		private String content;
		private String name;
		private long fileSize;
		
		
		public GalleryVo() {
			super();
		}
		
		public GalleryVo(String orgName, String saveName, String filePath, String content, long fileSize, int userNo) {
			super();
			this.orgName = orgName;
			this.saveName = saveName;
			this.filePath = filePath;
			this.content = content;
			this.fileSize = fileSize;
			this.userNo = userNo;
		}

		public GalleryVo(int no, String orgName, String saveName, String filePath, String content, int userNo,
				String name, long fileSize) {
			super();
			this.no = no;
			this.orgName = orgName;
			this.saveName = saveName;
			this.filePath = filePath;
			this.content = content;
			this.userNo = userNo;
			this.name = name;
			this.fileSize = fileSize;
		}
		
		
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
		public String getSaveName() {
			return saveName;
		}
		public void setSaveName(String saveName) {
			this.saveName = saveName;
		}
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public int getUserNo() {
			return userNo;
		}
		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getFileSize() {
			return fileSize;
		}
		public void setFileSize(long fileSize) {
			this.fileSize = fileSize;
		}
		public MultipartFile getFile() {
			return file;
		}
		public void setFile(MultipartFile file) {
			this.file = file;
		}
		
		@Override
		public String toString() {
			return "GalleryVo [no=" + no + ", orgName=" + orgName + ", saveName=" + saveName + ", filePath=" + filePath
					+ ", content=" + content + ", userNo=" + userNo + ", name=" + name + ", fileSize=" + fileSize + "]";
		}
		
		
	

}
