package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ReBoardDao;
import com.javaex.vo.ReBoardVo;

@Service
public class ReBoardService {

	@Autowired
	ReBoardDao rboardDao;
	
	public List<ReBoardVo> exeList() {
		System.out.println("ReBoardService.exeList()");
		return rboardDao.rboardList();
	}
	
	public ReBoardVo exeRead(int no) {
		System.out.println("ReBoardService.exeRead()");
		return rboardDao.rboardRead(no);
	}
	
}
