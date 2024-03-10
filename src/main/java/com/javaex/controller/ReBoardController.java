package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.ReBoardService;
import com.javaex.vo.ReBoardVo;

@Controller
@RequestMapping("/rboard")
public class ReBoardController {
	
	@Autowired
	ReBoardService rboardService;

	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("ReBoardController.list()");
		
		List<ReBoardVo> commentList = rboardService.exeList();
		model.addAttribute("cList", commentList);
		System.out.println(commentList);
		
		return "rboard/list";
	}
	@RequestMapping(value="/read", method={RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("ReBoardController.read()");
		
		ReBoardVo rboardVo = rboardService.exeRead(no);
		model.addAttribute("rbVo", rboardVo);
		System.out.println("read: "+rboardVo);
		
		return "rboard/read";
	}
	
	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})
	public String write() {
		System.out.println("ReBoardController.write()");
		
		return "";
	}
	
}
