package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ReBoardVo;

@Repository
public class ReBoardDao {
	
	@Autowired
	SqlSession sqlsession;

	public List<ReBoardVo> rboardList() {
		System.out.println("ReBoardDao.rboardList()");
		return sqlsession.selectList("rboard.select");
	}
	
	public ReBoardVo rboardRead(int no) {
		System.out.println("ReBoardDao.rboardRead()");
		return sqlsession.selectOne("rboard.select", no);
	}
	
}
