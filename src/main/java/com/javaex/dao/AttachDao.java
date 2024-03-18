package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.AttachVo;

@Repository
public class AttachDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public String upload(MultipartFile file) {
		System.out.println("AttachDao.upload()");
		String saveName = file.getOriginalFilename();
		return saveName;
	}
	
	public int attachInsert(AttachVo attachVo) {
		System.out.println("AttachDao.attachInsert()");
		sqlSession.insert("gallery.insert", attachVo);
		return 0;
	}

}
