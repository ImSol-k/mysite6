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
	public int userInsert(UserVo userVo) {
		System.out.println("userDao.userInsert()");
		
		System.out.println(userVo);
		return sqlSession.insert("user.insert",userVo);
	}
	
	//회원정보수정
	public UserVo userUpdateSelect(int no) {
		System.out.println("userDao.userUpdate()");
		
		return sqlSession.selectOne("user.selectUpdate", no);
	}
	public int userUpdate(UserVo userVo) {
		System.out.println("userDao.userUpdate()" + userVo);
		
		return sqlSession.update("user.update", userVo);
	}
}
