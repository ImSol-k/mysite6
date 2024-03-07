package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVo> exeList(){
		System.out.println("GuestbookService.exeList()");
		return guestbookDao.gbList();
	}
	public int exedelete(GuestbookVo guestVo) {
		System.out.println("GuestbookService.exedelete()");
		return guestbookDao.gbDelete(guestVo);
	}
	
}
