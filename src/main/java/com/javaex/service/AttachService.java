package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.AttachDao;
import com.javaex.vo.AttachVo;

/******************************
 * 
 */

@Service
public class AttachService {
	
	@Autowired
	private AttachDao attachDao;
	
	/******************************
	 * Img UpLoad
	 *  -exeUpload()
	 */
	public String exeUpload(MultipartFile file) {
		System.out.println("AttachService.exeUpload()");
		attachDao.upload(file);
		
		/**[0]파일관련 정보 수집 **/
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: " + orgName);
		//확장자
		String exeName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exeName: " + exeName);
		System.out.println("orgName(5): " + orgName.substring(11));
		//저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+ exeName;
		System.out.println("saveName: " + saveName);
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize: " + fileSize);
		//파일경로
		String saveDir = "C:\\javaStudy\\upload";
		String filePath = saveDir + "\\" + saveName;
		
		
		/**[1] 파일정보 DB에 저장 **/
		//vo로 묶어주기
		AttachVo attachVo = new AttachVo(orgName, saveName, filePath, fileSize);
		System.out.println(attachVo);
		//Dao로 저장
		attachDao.attachInsert(attachVo);
		
		/**[2] 하드디스크에 파일저장 **/
		// 파일저장
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
