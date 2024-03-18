package com.javaex.vo;

public class GalleryVo {

		private int no;
		private String orgName;
		private String saveName;
		private String filePath;
		private String content;
		private String userNo;
		private String name;
		private long fileSize;
		
		
		public GalleryVo() {
			super();
		}
		public GalleryVo(int no, String orgName, String saveName, String filePath, String content, String userNo,
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
		public String getUserNo() {
			return userNo;
		}
		public void setUserNo(String userNo) {
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
		
		
		
		
		@Override
		public String toString() {
			return "GalleryVo [no=" + no + ", orgName=" + orgName + ", saveName=" + saveName + ", filePath=" + filePath
					+ ", content=" + content + ", userNo=" + userNo + ", name=" + name + ", fileSize=" + fileSize + "]";
		}
		
		
	

}
