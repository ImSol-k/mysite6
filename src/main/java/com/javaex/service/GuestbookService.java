package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;

	// list
	public List<GuestbookVo> exeList() {

		return guestbookDao.guestList();
	}

	// 등록
	public void exeInsert(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeInsert()");

		guestbookDao.guestbookInsert(guestbookVo);
	}

	// 삭제
	public void exeDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeDelete()");

		guestbookDao.guestbookDelete(guestbookVo);
	}
	
	/***********************************
	 * ajax
	 * */
	//ajax 저장
	public GuestbookVo exeAddandGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeAddandGuest()");
		//저장
		guestbookDao.insertSelectkey(guestbookVo);
		//데이터 가져오기
		GuestbookVo gbVo = guestbookDao.guestbookSelectOne(guestbookVo.getNo());
		return gbVo;
	}
	
	public int exeDeleteGuest(GuestbookVo guestbookVo) {
		int count = guestbookDao.guestbookDelete(guestbookVo);
		System.out.println("Service"+count);
		return count;
	}
}
