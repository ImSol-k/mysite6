package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// List
	public List<GuestbookVo> guestList() {

		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.select");
		return guestbookList;
	}

	// 등록
	public int guestbookInsert(GuestbookVo guestbookVo) {
		System.out.println("GusetbookDao.guestbookInsert()");

		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		return count;
	}

	// 삭제
	public int guestbookDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.guestbookDelete()");

		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		return count;
	}

	/*********************************
	 * ajax
	 */
	// ajax등록
	public int insertSelectkey(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertSelectkey()");
		
		sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		return guestbookVo.getNo();
	}

	public GuestbookVo guestbookSelectOne(int no) {
		System.out.println("GuestbookDao.guestbookSelectOne()");
		
		// 불러온 마지막번호로 select
		GuestbookVo gbVo = sqlSession.selectOne("guestbook.selectOne", no);
		return gbVo;
	}
	
//	public int geustbookRemove(GuestbookVo guestbookVo) {
//		int count = sqlSession.delete("guestbook.delete");
//		System.out.println("ajax"+guestbookVo);
//		return count;
//	}

}
