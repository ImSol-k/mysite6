package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("guest")
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookService;
	
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVo> guestList = guestbookService.exeList();
		model.addAttribute("gList", guestList);
		
		return "guestbook/addList";
	}
	
	//삭제
	@RequestMapping(value="/deleteform", method={RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("GuestbookController.deleteForm()");
		return "guestbook/deleteForm";
	}
	@RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestVo) {
		System.out.println("GuestbookController.delete()");
		
		System.out.println(guestVo);
		guestbookService.exedelete(guestVo);
		return "redirect:/guest/list";
	}
}
