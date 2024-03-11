package com.javaex.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.ReBoardService;
import com.javaex.vo.ReBoardVo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/rboard")
public class ReBoardController {
	
	@Autowired
	ReBoardService rboardService;

	/**************************************
	 * list
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("ReBoardController.list()");
		
		List<ReBoardVo> commentList = rboardService.exeList();
		model.addAttribute("cList", commentList);
		System.out.println(commentList);
		
		return "rboard/list";
	}
	/***************************************
	 * read
	 */
	@RequestMapping(value="/read", method={RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("ReBoardController.read()");
		
		ReBoardVo rboardVo = rboardService.exeRead(no);
		model.addAttribute("rbVo", rboardVo);
		System.out.println("read: "+rboardVo);
		
		return "rboard/read";
	}
	/***************************************
	 * write
	 */
	@RequestMapping(value="/writeform", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm(Model model) {
		System.out.println("ReBoardController.writeForm()");
		
		List<ReBoardVo> commentList = rboardService.exeList();
		model.addAttribute("cList", commentList);
		System.out.println(commentList);
		
		return "rboard/writeList";
	}
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("title") String title,
						@RequestParam("content") String content,
						@RequestParam("no") int no) {
		System.out.println("ReBoardController.write()");
		ReBoardVo rbVo = new ReBoardVo(no, title, content);
		rboardService.exeWrite(rbVo);
		
		return "redirect:/rboard/list";
	}
	
}
