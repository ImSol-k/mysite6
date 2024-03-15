package com.javaex.contoller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

import jakarta.websocket.server.PathParam;

/*******************************************************
 * Guestbook 
 *  -API, json사용
 *******************************************************/

@Controller
@RequestMapping("api")
public class APIGuestbookController {

	@Autowired
	GuestbookService guestbookService;

	
	/********************************
	 * 리스트
	 * @ResponseBody 
	 * ㄴreturn값을 json으로 변경 
	 * ㄴresponseType: 'json'
	 ********************************/
	@ResponseBody
	@RequestMapping(value = "/guestbooks", method = RequestMethod.GET)
	public List<GuestbookVo> addList() {
		System.out.println("APIGuestbookController.addList()");

		List<GuestbookVo> guestList = guestbookService.exeList();

		return guestList;
	}

	/*********************************
	 * 등록
	 * @param guestbookVo
	 * @return
	 *********************************/
	@ResponseBody
	@RequestMapping(value = "/guestbooks", method = RequestMethod.POST)
	public GuestbookVo add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("APIGuestbookController.add()");

		GuestbookVo gbVo = guestbookService.exeAddandGuest(guestbookVo);
		return gbVo;
	}

	/***************************
	 * 삭제 
	 * @PathVariable
	 * ㄴ주소에 값 넘기기
	 ***************************/
	@ResponseBody
	@RequestMapping(value = "/guestbooks/{no}", method = RequestMethod.DELETE)
	public int delete(@PathVariable("no") int num, @ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("APIGuestbookController.delete("+ num +")");
		guestbookVo.setNo(num);
		System.out.println(guestbookVo);
		int count = guestbookService.exeDeleteGuest(guestbookVo);
		return count;
	}

}
