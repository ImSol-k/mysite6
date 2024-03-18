package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.AttachVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlsession;
	
	public List<AttachVo> gallerySelectAll() {
		System.out.println("GalleryDao.gallerySelectAll()");
		List<AttachVo> galleryList = sqlsession.selectList("gallery.selsct");
		return galleryList;
	}
}
