package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	//리스트
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(@RequestParam String find, HttpSession session) {
		System.out.println("BoardController.list()");

		List<BoardVo> boardList = boardService.exeList();
		session.setAttribute("bList", boardList);
		return "board/list";
	}
	
	//읽기
	@RequestMapping(value="/read", method={RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam int no, Model model) {
		System.out.println("BoardController.read()");
		
		BoardVo boardVo = boardService.exeRead(no);
		model.addAttribute(boardVo);
		System.out.println(boardVo);
		
		return "board/read";
	}
	
	//쓰기폼
	@RequestMapping(value="/writeform", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("BoardController.writeForm()");

		return "board/writeForm";
	}
	//쓰기
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
		System.out.println("BoardController.write()");
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		
		int no = userVo.getNo();
		boardVo.setUserNo(no);
		boardService.exeWrite(boardVo);
		
		return "redirect:/board/list";
	}
	
	//수정폼
	@RequestMapping(value="/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam int no, Model model) {
		System.out.println("BoardController.modifyForm()");
		
		BoardVo boardVo = boardService.exeRead(no);
		model.addAttribute(boardVo);
		
		return "board/modifyForm";
	}
	//수정
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.modify()");
		boardService.exeModify(boardVo);
		return "redirect:/board/read?no="+boardVo.getNo();
	}
	
	//검색
	@RequestMapping(value="/find", method= {RequestMethod.GET, RequestMethod.POST})
	public String findForm(@RequestParam("find") String find, HttpSession session) {
		System.out.println("BoardController.find()");
		
		List<BoardVo> findList = boardService.exeFind(find);
		session.setAttribute("findList", findList);
		
		System.out.println(findList);
		
		return "board/list";
	}
	
}
