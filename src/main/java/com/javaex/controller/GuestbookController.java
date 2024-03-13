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

	/**************************************************************
	 * Guestbook Controller
	 *  -일반 방명록
	 **************************************************************/
	//list
	@RequestMapping(value = "/addlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestbookController.addList()");

		List<GuestbookVo> guestbookList = guestbookService.exeList();
		model.addAttribute("gList", guestbookList);

		return "/guestbook/addList";
	}

	//insert
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestInsert(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.GuestInsert()");

		guestbookService.exeInsert(guestbookVo);

		return "redirect:/guest/addlist";
	}

	//deleteform
	@RequestMapping(value = "/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestDeleteForm() {
		System.out.println("GuestbookController.deleteForm()");

		return "/guestbook/deleteForm";
	}

	//delete
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestDelete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.deleteForm()");

		guestbookService.exeDelete(guestbookVo);
		return "redirect:/guest/addlist";
	}
	
	/*********************************************************************
	 * ajax방명록
	 *  -api 사용
	 *********************************************************************/
	@RequestMapping(value = "/ajaxindex", method = { RequestMethod.GET, RequestMethod.POST })
	public String ajaxIndex() {
		System.out.println("GuestbookController.ajaxIndex()");
		return "/guestbook/ajaxIndex";
	}
	
	
	
}
