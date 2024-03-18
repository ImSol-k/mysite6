package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	//리스트
	public List<BoardVo> boardSelect() {
		System.out.println("BoardDao.boardSelect()");

		return sqlSession.selectList("board.select");
	}
	
	//수정폼
	public BoardVo boardSelectOne(int no) {
		System.out.println("BoardDao.boardSelectOne()");
		return sqlSession.selectOne("board.selectOne", no);
	}
	//수정
	public int boardUpdate(BoardVo boardVo) {
		return sqlSession.update("board.update", boardVo);
	}

	//읽기
	public int boardInsert(BoardVo boardVo) {
		System.out.println("BoardDao.boardInsert()");

		return sqlSession.insert("board.insert", boardVo);
	}
	
	//검색
	public List<BoardVo> boardFind(String find) {
		System.out.println("BoardDao.boardFind()");
		
		return sqlSession.selectList("board.find", find);
	}

}
