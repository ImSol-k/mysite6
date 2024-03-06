package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	SqlSession sqlSession;

	public List<BoardVo> boardSelect() {
		System.out.println("BoardDao.boardSelect()");

		return sqlSession.selectList("board.select");
	}
	
	public BoardVo boardSelectOne(int no) {
		System.out.println("BoardDao.boardSelectOne()");
		return sqlSession.selectOne("board.selectOne", no);
	}
	public int boardUpdate(BoardVo boardVo) {
		return sqlSession.update("board.update", boardVo);
	}

	public int boardInsert(BoardVo boardVo) {
		System.out.println("BoardDao.boardInsert()");

		return sqlSession.insert("board.insert", boardVo);
	}

}
