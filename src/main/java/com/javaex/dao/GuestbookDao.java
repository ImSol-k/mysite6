package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<GuestbookVo> gbList() {
		System.out.println("GuestbookDao.guestbookList()");
		
		return sqlSession.selectList("guest.select");
	}
	
	public int gbDelete(GuestbookVo guestVo) {
		System.out.println("GuestbookDao.gbDelete()");
		return sqlSession.delete("guest.delete", guestVo);
	}
	
}
