package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;

	public List<BoardVo> exeList() {
		System.out.println("BoardService.exeList()");

		return boardDao.boardSelect();
	}
	
	public BoardVo exeRead(int no) {
		return boardDao.boardSelectOne(no);
	}
	
	public int exeModify(BoardVo boardVo) {
		return boardDao.boardUpdate(boardVo);
	}

	public int exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite()");

		return boardDao.boardInsert(boardVo);
	}
}
