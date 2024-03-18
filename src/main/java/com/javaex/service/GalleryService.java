package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.AttachVo;
import com.javaex.vo.GalleryVo;
/**********************
 * GalleryService
 **********************/
@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	public List<GalleryVo> exeList() {
		System.out.println("GalleryService.exeList()");
		List<GalleryVo> galleryList =  galleryDao.gallerySelectAll();
		return galleryList;
	}

	public String exeUpload(int no, String content, MultipartFile file) {
		System.out.println("GalleryService.exeUpload()");
		
		/** 파일정보수집 **/
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: " + orgName);
		String exeName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exeName: " + exeName);
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+ exeName;
		System.out.println("saveName: " + saveName);
		long fileSize = file.getSize();
		System.out.println("fileSize: " + fileSize);
		String saveDir = "C:\\javaStudy\\workspace_sb\\mysite6\\src\\main\\webapp\\assets\\galleryImg";
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath: " + filePath);
		System.out.println("content: " + content);
		
		/** db저장 **/
		GalleryVo galleryVo = new GalleryVo(orgName, saveName, filePath, content, fileSize, no);
		galleryDao.galleryInsert(galleryVo);
		
		/** 파일저장 **/
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
	}
}
