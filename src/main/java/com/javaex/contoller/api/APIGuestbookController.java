package com.javaex.contoller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("api")
public class APIGuestbookController {
	
	@Autowired
	GuestbookService guestbookService;

	/*******************************************************
	 * Guestbook
	 *  -API, json사용 
	 * @ResponseBody
	 *  ㄴreturn값을 json으로 변경 
	 *  ㄴresponseType: 'json'
	 *******************************************************/
	@ResponseBody
	@RequestMapping(value = "/guestbooks", method = RequestMethod.GET)
	public List<GuestbookVo> addList() {
		System.out.println("APIGuestbookController.addList()");
		
		List<GuestbookVo> guestList = guestbookService.exeList();
		
		return guestList;
	}
}
 