package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/loginform", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginform()");
		
		return "user/loginForm";
	}
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");

		UserVo authUser = userService.exeLogin(userVo);

		//로그인성공여부
		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			System.out.println("로그인성공" + authUser);
			return "redirect:/main";
		} else {
			System.out.println("로그인실패");
			return "user/loginForm";
		}

	}
	/**********
	 * logout */
	@RequestMapping(value="/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session){
		System.out.println("UserController.logout()");
		
		session.invalidate();
		
		return "redirect:/main";
	}
	/*********
	 * join	 */
	@RequestMapping(value="/joinform", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinform()");
		
		return "user/joinForm";
	}

	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join()");

		//아이디 중복체크
		if("?".equals(userVo.getId())) {
			userService.exeJoin(userVo);
			System.out.println("회원가입 성공");
			return "user/joinOk";
		} else {
			System.out.println("회원가입 실패");
			return "redirect:/user/joinform";
		}
	}
	/**********
	 * modify */
	@RequestMapping(value="/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		System.out.println("UserController.mform()");
		
		return "user/modifyForm";
	}
	
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(HttpSession session,@ModelAttribute UserVo userVo) {
		System.out.println("UserController.modify()");
		
		userService.exeModify(userVo);
		session.setAttribute("authUser", userVo);
		
		return "redirect:/main";
	}
	
}
