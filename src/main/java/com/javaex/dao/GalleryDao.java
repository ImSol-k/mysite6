package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.GalleryVo;
/**********************
 * GalleryDao
 **********************/
@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;
	
	/*****************************
	 * 리스트
	 */
	public List<GalleryVo> gallerySelectAll() {
		System.out.println("GalleryDao.gallerySelectAll() **");
		List<GalleryVo> galleryList = sqlSession.selectList("gallery.select");
		return galleryList;
	}
	/*****************************
	 * 업로드
	 */
	 public String galleryInsert(GalleryVo galleryVo) {
		 System.out.println("GalleryDao.galleryInsert() **");
		 sqlSession.insert("gallery.insert", galleryVo);
		 return "";
	 }
}
