package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public List<BoardVo> exeList() {
		System.out.println("BoardService.exeList()");
		return boardDao.boardSelect();
	}
	
	public BoardVo exeRead(int no) {
		System.out.println("BoardService.exeRead()");
		return boardDao.boardSelectOne(no);
	}
	
	public int exeModify(BoardVo boardVo) {
		System.out.println("BoardService.exeModify()");
		return boardDao.boardUpdate(boardVo);
	}

	public int exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite()");

		return boardDao.boardInsert(boardVo);
	}
	
	public List<BoardVo> exeFind(String find){
		System.out.println("BoardService.exeFind()");
		return boardDao.boardFind(find);
	}
	
}
