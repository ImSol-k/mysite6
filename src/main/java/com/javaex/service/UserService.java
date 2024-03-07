package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin()");
		
		UserVo authUser = userDao.userSelectOne(userVo);
		return authUser;
	}
	
	//회원가입
	public int exeJoin(UserVo userVo) {
		System.out.println("UserService.exeJoin()");
		
		return userDao.userInsert(userVo);
	}

	//회원정보수정
	public UserVo exeModifyF(int no) {
		System.out.println("userService.exeModify()");
		return userDao.userUpdateSelect(no);
	}
	public int exeModify(UserVo userVo) {
		System.out.println("userService.exeModify()");
		return userDao.userUpdate(userVo);
	}
}
