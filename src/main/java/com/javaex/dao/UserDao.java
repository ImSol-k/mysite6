package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	//로그인
	public UserVo userSelectOne(UserVo userVo) {
		System.out.println("userDao.userSelectOne()");

		UserVo authuser = sqlSession.selectOne("user.selectOne", userVo);

		return authuser;
	}
	
	//회원가입
	public void userInsert(UserVo userVo) {
		System.out.println("userDao.userInsert()");
		
		System.out.println(userVo);
		sqlSession.insert("user.insert",userVo);
	}
	
	//회원정보수정
	public void userUpdate(UserVo userVo) {
		System.out.println("userDao.userUpdate()");
		
		sqlSession.update("user.update", userVo);
		
	}
}
