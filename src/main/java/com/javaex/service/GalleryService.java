package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.AttachVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	public List<AttachVo> exeList() {
		System.out.println("GalleryService.exeList()");
		List<AttachVo> galleryList =  galleryDao.gallerySelectAll();
		return galleryList;
	}

}
